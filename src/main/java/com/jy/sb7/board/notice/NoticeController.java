package com.jy.sb7.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.board.BoardVO;
import com.jy.sb7.utill.Pager;


@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@ModelAttribute(name="board")
	public String getBoard() {
		return "notice";
	}

	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Pageable pageable = PageRequest.of(pager.getPage(), pager.getSize());
		Page<NoticeVO> page = noticeService.getList(pageable);
		pager.makePage(page);
				
		mv.addObject("pager", pager);
		mv.addObject("page", page);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	
	/* 파일 업로드 버전 */
//	@PostMapping("noticeWrite") 
//	public ModelAndView setInsert(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
//		System.out.println("Notice Insert Controller 진입"); 
//		ModelAndView mv = new ModelAndView();
//			  
//		noticeService.setInsert(noticeVO, files);
//		mv.setViewName("redirect:./noticeList");
//		  
//		return mv;
//	}
	 
		
	/* summernote만 사용 버전 */
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(NoticeVO noticeVO) throws Exception {
		System.out.println("Notice Insert");
		noticeVO = noticeService.setInsert(noticeVO);
		
		String msg = "공지사항 등록 실패";
		if(noticeVO != null) {
			System.out.println(noticeVO.getNum());
			msg = "공지사항 등록 성공";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		return mv; 
	}
	
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(NoticeVO noticeVO) throws Exception {
		System.out.println("Notice Select");
		ModelAndView mv = new ModelAndView();
		
		noticeVO.setHit(noticeVO.getHit()+1);
		int hitUpdate = noticeService.setUpdateHit(noticeVO);
		System.out.println("조회수 업그레이드 : "+hitUpdate);
		
		noticeVO = noticeService.getOne(noticeVO);
		
		mv.addObject("notice", noticeVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
//	@GetMapping("noticeFileDown")
//	public ModelAndView getFileDown(NoticeFileVO noticeFileVO) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		noticeFileVO = noticeService.getFileDown(noticeFileVO);
//		
//		mv.addObject("noticeFileVO", noticeFileVO);
//		mv.addObject("filePath", filePath);
//		mv.setViewName("fileDown");
//		
//		return mv;
//	}
	
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(NoticeVO noticeVO) throws Exception {
		System.out.println("Notice Update");
		ModelAndView mv = new ModelAndView();
		
		noticeVO = noticeService.getOne(noticeVO);
		
		mv.addObject("notice", noticeVO);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(noticeVO, files);
		System.out.println("결과 : "+result);
		
		String msg = "업데이트 실패";
		String path = "./noticeUpdate?num="+noticeVO.getNum();
		if(result > 0) {
			msg = "업데이트 성공";
			path = "./noticeList";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(NoticeVO noticeVO) throws Exception {
		System.out.println("Notice Delete");
		ModelAndView mv = new ModelAndView();
		
		boolean result = noticeService.setDelete(noticeVO);
		String msg = "해당 번호의 게시글이 존재하지 않습니다.";
		if(result) {
			msg = "삭제 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
}
