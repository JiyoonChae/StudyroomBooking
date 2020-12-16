package com.jy.sb7.member;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;

	
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
