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
		String msg = "1:1 문의 등록 실패. 다시 입력해주세요.";
		
		qnaVO = qnaService.setInsert(qnaVO);
		if(qnaVO != null) {
			msg = "1:1 문의 완료되었습니다. <br>관리자가 확인 후 답변드릴 예정입니다.";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaWrite");
		mv.setViewName("common/result");
		return mv;
	}
}
