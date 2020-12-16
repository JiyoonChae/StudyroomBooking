package com.jy.sb7.member;

import javax.annotation.PostConstruct;

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

	//login
	@PostMapping("memberLogin")
	public void getMemberLogin(MemberVO memberVO) throws Exception{
		memberService.getMemberLogin(memberVO);
	}
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
		
	}
}
