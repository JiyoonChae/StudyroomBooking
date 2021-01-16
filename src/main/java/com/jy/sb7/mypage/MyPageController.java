package com.jy.sb7.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/mypage/**")
public class MyPageController {
	
	@Autowired
	private MyPageService myPageService;
	
	@ModelAttribute(name="sub")
	public String getPage() {
		return "reservation";
	}
	
	@GetMapping("reservationList")
	public ModelAndView getList() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("mypage/reservationList");
		return mv;
	}
}
