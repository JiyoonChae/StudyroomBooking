package com.jy.sb7.member;


import jdk.internal.util.jar.JarIndex;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	Map<String, Object> map = new HashMap<>();
	
	//이메일 인증 key 확인
	@PostMapping("keyCheck")
	public void keyCheck(String key) throws Exception{
		System.out.println("넘어온key" +key);
		System.out.println("저장된맵키:" + map.get("key"));
		if(key==map.get("key")) {
			System.out.println("일치 - 성공");
		}
	}
	
	//이메일 인증 요청
	@RequestMapping(value ="checkEmail", method = {RequestMethod.GET })
	@ResponseBody 
	public Map<String, Object> emailCheck(String email) throws Exception{
		
		System.out.println("email인증 접근:" + email);
		Random random = new Random(); 
		String key=""; //인증번호
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 스크립트에서 보낸 메일을 받을 사용자 이메일 주소
		//입력키를 위한 코드
		for(int i=0; i<3; i++) {
			int index= random.nextInt(25)+65; // A-Z까지 랜덤 알파벳 생성
			key+=(char)index;
  		}
		int numIndex = random.nextInt(9999)+1000; // 4자리 랜덤 정수를 생성
		key+=numIndex;
		System.out.println("인증번호: "+key);
		message.setSubject("인증번호 입력을 위한 메일 전송");
		message.setText("인증번호 : "+key);
		javaMailSender.send(message);
		System.out.println("이메일 전송 완료!!");
		map.put("key", key);
		System.out.println("key : "+key);
		return map;
	}
	
	//회원가입 페이지
	@GetMapping("memberJoin")
	public ModelAndView memberJoin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "회원가입");
		return mv;
	}
	
	//네이버 로그인
	@RequestMapping(value ="personalInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void personalInfo(HttpServletRequest requeset)throws Exception{
		String token ="AAAANjm6a2HyubXjEyyscLUO1zNrFB9xLzfiCQPGRoso--DsMZSMEmEc-MyFP6K9n7qXJtKZhCYwor3c3TAn-vJlc6Y";
		String header="Bearer "+token;
		  try {
		String apiURL="https://openapi.naver.com/v1/nid/me";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", header);
		int responseCode=con.getResponseCode();
		BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	     
	    	  System.out.println("결과??:"+res.toString());
	      
	    } catch (Exception e) {
	      System.out.println(e);
	    }
		
	}
	
	
	@RequestMapping(value="callback", method={RequestMethod.GET, RequestMethod.POST})
	public String callback(HttpServletRequest request) throws Exception{
		return"member/callback";
	}
		
	@GetMapping("naverlogin")
	public void naverlogin() throws Exception{
		
	}
	
	@RequestMapping(value="memberNaverLogin", method= {RequestMethod.GET, RequestMethod.POST})
	public String naverLogin(@RequestParam String access_token, @RequestParam String state) throws Exception{
		System.out.println("여기로오는건가..?");
		System.out.println(access_token);
		System.out.println(state);
		//1.code를 이용해서 access_token 받기
		//2. access_token을 이용해서 사용자 profile정보 가져오기
		//3. db에 해당 유저가 존재하는지 체크(googleid, naverid 컬럼 추가) 
		//4. 존재하면 강제로그인, 미존재시 가입페이지로!
		return "member/memberNaverLogin";
	}
	
	//log out
	@GetMapping("memberLogout")
	public String setLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	//이메일 중복 체크
	@GetMapping("emailCheck")
	@ResponseBody
	public int emailCheck(MemberVO memberVO) throws Exception {
		System.out.println("email check 컨트롤러:" +memberVO.getEmail());
		memberVO = memberService.emailCheck(memberVO);
		int result =1; //EMAIL 중복일때
		if(memberVO ==null) {
			result=0;
		}
		return result;
	}
	
	//아이디 중복체크
	@GetMapping("memberCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception{
		System.out.println("membercheck:"+memberVO.getId());
		System.out.println("email:"+memberVO.getEmail());
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.memberCheck(memberVO);
	//	System.out.println(memberVO.getId());
	//	System.out.println(memberVO.getEmail());
		int result =1; //id가 중복일때
		if(memberVO ==null) {
			result=0;
		}
		//mv.addObject("msg", result);
		//mv.setViewName("common/result");
		return result;
	}
	
	//login 로그인
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin (MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv= new ModelAndView();
		//System.out.println(memberVO.getId());
		//System.out.println(memberVO.getPw());
		MemberVO VO = memberService.getMemberLogin(memberVO);
		if(VO != null) {
			System.out.println("login 성공");
			session.setAttribute("member", VO);
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("msg", "로그인 정보가 맞지않습니다");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
			System.out.println("login 실패");
		}
		return mv;
	}
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
		
	}
	//아이디 찾기
	@PostMapping("findMyId")
	@ResponseBody
	public String findMyId(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("아이디 찾기 컨트롤러 들어옴"); 
		memberVO = memberService.findMyId(memberVO);
		String msg;
		if(memberVO ==null) {
			System.out.println("아이디찾기 실패");
			msg = "아이디 찾기 실패";
		}else {
			System.out.println("아이디찾기 성공");
			msg = memberVO.getId();
			
		}
	
		return msg;
	}
	

	//비밀번호 찾기
	@PostMapping("findMyPw")
	@ResponseBody
	public int findMyPw(MemberVO memberVO) throws Exception{
		//비번 체크를 위한 확인 id, email일치여부 
		memberVO = memberService.findMyPw(memberVO);
		
		String msg;
		int result=0;
		if(memberVO != null) {
			String email =memberVO.getEmail();
			String id = memberVO.getId();
			//일치하면 임시비번으로 업데이트 하고 이메일 보내야함.
			System.out.println("---임시비번 전송 접근---");
			Random random = new Random(); 
			String key=""; //인증번호
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email); // 메일을 받을 사용자 이메일 주소
				//임시 비번 생성을 위한 코드
				for(int i=0; i<3; i++) {
					int index= random.nextInt(25)+65; // A-Z까지 랜덤 알파벳 생성
					key+=(char)index;
					int numIndex = random.nextInt(9999)+1000; // 4자리 랜덤 정수를 생성
					key+=numIndex;
		  		}
		
			System.out.println("임시비번: "+key);
			memberVO.setPw(key); 
			//db에 임시비번 업데이트 하기
			result = memberService.updateTempPw(memberVO);
			System.out.println(result);
			
			message.setSubject("임시 비밀번호 메일 전송");
			message.setText("임시 비밀번호 : "+key);
			javaMailSender.send(message);
			System.out.println("임시 비번 전송 완료!!");
			map.put("key", key);
			msg = "임시 비번 전송 완료!!";
		}
		
		return result;
		}

		//비밀번호 변경
		@GetMapping("updatePw")
		public void updateMyPw() throws Exception{
			
		}
	
}
