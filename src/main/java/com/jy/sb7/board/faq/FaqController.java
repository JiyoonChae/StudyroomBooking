package com.jy.sb7.board.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/faq/**")
public class FaqController {

	@ModelAttribute(name="board")
	public String getBoard() {
		return "faq";
	}
	
	
	@GetMapping("faqList")
	public ModelAndView getList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList");
		return mv;
	}
}
