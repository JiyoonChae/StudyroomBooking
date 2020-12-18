package com.jy.sb7.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jy.sb7.member.MemberService;
import com.jy.sb7.member.MemberVO;

@Controller
@RequestMapping("/auth/**")
public class AuthController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("kakao/callback")
	public @ResponseBody String kakaoLogin(String code) throws Exception{ //responsebody는 DATA를 리턴해주는 컨트롤러 함수
		//post 방식으로 key=value 데이터를 요청 (카카오쪽으로) 
		//a태그로 요청하는 건 무조건 get방식.. 이때 필요한 라이브러리가 restTemplate
		//HttpURLConnection 도 사용할 수있는데 쫌 불편?
		//Retrofit2, OkHttp 이런것도 많이 씀.
		
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		//Content-type이 하는 역할은 header에 내가 전송할 http body데이터들이 key=value형태의 data라고 알려주는것!
		
		//http body데이터들을 담을 오브젝트
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		//params.add(key, value);
		params.add("grant_type", "authorization_code");
		params.add("client_id", "db6b291272bd77842e5db5fa28f52e1a");
		params.add("redirect_uri", "http://localhost/auth/kakao/callback");
		params.add("code", code);
		
		//body안의 데이터와 header 값을 가진 Entity를 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		
		ResponseEntity<String> response = rt.exchange(
				//1. 토큰 발급 요청 주소
				//2. 요청 메서드
				//3. 데이터들 -body, header
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		
			//받은 json 토큰 결과를 처리하기 힘드니까 오브젝트 만들기
			//Gson, Json Simple, ObjectMapper 라이브러리 중 선택하면됨. 
		ObjectMapper objectMapper = new ObjectMapper(); //기본 내장되어있음
		OAuthToken oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		System.out.println("카카오 엑세스 토근:"+oauthToken.getAccess_token());
		
		//**********************사용자 정보 요청 **************************************
		RestTemplate rt2 = new RestTemplate();
		//HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		//Content-type이 하는 역할은 header에 내가 전송할 http body데이터들이 key=value형태의 data라고 알려주는것!
		
		
		//HttpHeader 는 밑에 exchage가 HttpEntity를 받기때문에 변환해주는것
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);
		
		//Http 요청하기 - post방식으로 -
		ResponseEntity<String> response2 = rt2.exchange(
				//1. 토큰 발급 요청 주소
				//2. 요청 메서드
				//3. 데이터들 -body, header
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				kakaoProfileRequest,
				String.class
				);
		
		ObjectMapper objectMapper2 = new ObjectMapper(); //기본 내장되어있음	
		KakaoProfile kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class); // kakaoProfile에 모든 정보를 담게함.
		
		System.out.println("카카오 아이디: " + kakaoProfile.getId());
		System.out.println("카카오 이메일: "+ kakaoProfile.getKakao_account().getEmail());
		//memberVO 오브젝트?.. id, pw, email, name
		System.out.println("내서버 유저네임:"+kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
		System.out.println("내서버 이메일:"+kakaoProfile.getKakao_account().getEmail());
		System.out.println("내서버 패스워드:" +"kakao."+kakaoProfile.getId());
		
		MemberVO memberVO = new MemberVO();
				memberVO.setId(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
				memberVO.setPw("kakao."+kakaoProfile.getId());
				memberVO.setEmail(kakaoProfile.getKakao_account().getEmail());
		
		memberService.setMemberJoin(memberVO);
		return response2.getBody();  //getBody, getHeader따로 가져올수있음! 
	}
}
