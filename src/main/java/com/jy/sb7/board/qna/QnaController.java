package com.jy.sb7.board.qna;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@Value("${board.qna.filePath}")
	private String filePath;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("qnaWrite")
	public String setInsert() throws Exception {
		return "qna/qnaWrite";
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(QnaVO qnaVO) throws Exception {
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("qna/qnaWrite");
		return mv;
	}
}
