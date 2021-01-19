package com.jy.sb7.board.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.board.BoardVO;
import com.jy.sb7.utill.Pager;

@Controller
@RequestMapping(value="/faq/**")
public class FaqController {

	@Autowired
	private FaqService faqService;
	
	@ModelAttribute(name="board")
	public String getBoard() {
		return "faq";
	}
	
	
	@GetMapping("faqList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("FAQ List Controller");
		System.out.println(pager.getSearchType());
		System.out.println(pager.getKeyword());
		
		Pageable pageable = PageRequest.of(pager.getPage(), pager.getSize());
		Page<BoardVO> page = faqService.getSearchList(pager, pageable);
		pager.makePage(page);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pager", pager);
		mv.addObject("page", page);
		mv.setViewName("board/boardListSlide");
		return mv;
	}
	
	@GetMapping("faqWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("faqWrite")
	public ModelAndView setInsert(FaqVO faqVO) throws Exception {
		System.out.println("Faq Insert");
		System.out.println("카테고리 : "+ faqVO.getCategory());
		System.out.println("질문 : " + faqVO.getTitle());
		System.out.println("답변 : " + faqVO.getContents());
		System.out.println("----------------------");
		
		faqVO = faqService.setInsert(faqVO);
		
		String msg = "FAQ 등록 실패.. 다시 시도해주세요";
		String path = "./faqWrite";
		if(faqVO != null) {
			msg = "FAQ 등록 성공";
			path = "./faqList";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("faqUpdate")
	public String setUpdate(FaqVO faqVO, Model model) throws Exception {
		System.out.println("FAQ Update Controller");
		
		faqVO = faqService.getOne(faqVO);
		model.addAttribute("vo", faqVO);
		
		return "board/boardUpdate";
	}
	
	@PostMapping("faqUpdate")
	public ModelAndView setUpdate(FaqVO faqVO) throws Exception {
		int result = faqService.setUpdate(faqVO);
		
		String msg = "업데이트 실패";
		String path = "./faqUpdate?num="+faqVO.getNum();
		if(result > 0) {
			msg = "업데이트 성공";
			path = "./faqList?page=0&searchType=전체&keyword=";
		}
		
		ModelAndView mv = new ModelAndView();		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("faqDelete")
	public ModelAndView setDelete(FaqVO faqVO) throws Exception {
		System.out.println("FAQ Delete Controller");
		
		boolean result = faqService.setDelete(faqVO);
		String msg = "해당 번호의 게시글이 존재하지 않습니다.";
		if(result) {
			msg = "삭제 성공";
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", "./faqList?page=0&searchType=전체&keyword=");
		mv.setViewName("common/result");
		
		return mv;
	}
}
