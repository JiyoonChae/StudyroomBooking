package com.jy.sb7.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.board.BoardVO;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute(name="board")
	public String getBoard() {
		return "notice";
	}

	
	@GetMapping("noticeList")
	public ModelAndView getList() throws Exception {
		ModelAndView mv = new ModelAndView();
		
//		Pageable pageable = PageRequest.of(0, 10, Direction.DESC);
//		Page<NoticeVO> page;
		List<NoticeVO> noticeList = noticeService.getList();
		
		mv.addObject("list", noticeList);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert(@ModelAttribute NoticeVO noticeVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	/*
	 * @PostMapping("noticeWrite") public ModelAndView setInsert(NoticeVO noticeVO,
	 * MultipartFile[] files) throws Exception {
	 * System.out.println("Notice Insert Controller 진입"); ModelAndView mv = new
	 * ModelAndView();
	 * 
	 * noticeService.setInsert(noticeVO, files);
	 * 
	 * mv.setViewName("redirect:./noticeList");
	 * 
	 * return mv; }
	 */
	
	
	@PostMapping("noticeWrite") 
	public ModelAndView setInsert(NoticeVO noticeVO) throws Exception {
		System.out.println("Notice Insert Controller 진입");
		
		ModelAndView mv = new ModelAndView();
		noticeVO = noticeService.setInsert(noticeVO);
		
		if(noticeVO!=null) {
			System.out.println(noticeVO.getNum());
		}
		mv.setViewName("redirect:./noticeList");
		  
		return mv;
	}
	
	
	
}
