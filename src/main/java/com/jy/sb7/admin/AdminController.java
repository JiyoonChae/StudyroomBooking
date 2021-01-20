package com.jy.sb7.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.member.MemberVO;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminController {

	@GetMapping("index")
	public ModelAndView getAdminIndex() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/adminIndex");
		return mv;
	}
	
	@GetMapping("adminLogout")
	public ModelAndView getAdminLogout(HttpSession session) throws Exception {
		//로그아웃시 session 유지시간 0초로 강제 변경
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "로그아웃하였습니다.");
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
}