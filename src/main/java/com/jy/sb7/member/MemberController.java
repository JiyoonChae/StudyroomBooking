package com.jy.sb7.member;


import jdk.internal.util.jar.JarIndex;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "회원가입");
		return mv;
	}
	
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
	//login
	@PostMapping("memberLogin")
	public String getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getPw());
		MemberVO VO = memberService.getMemberLogin(memberVO);
		if(VO != null) {
			System.out.println("login 성공");
			session.setAttribute("member", VO);
			return "redirect:../";
		}else {
			System.out.println("login 실패");
		}
		return null;
	}
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
		
	}
}
