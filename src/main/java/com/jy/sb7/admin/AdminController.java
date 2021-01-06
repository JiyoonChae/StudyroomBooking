package com.jy.sb7.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminController {

	@GetMapping("index")
	public ModelAndView getAdminIndex() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/adminIndex");
		return mv;
	}
}