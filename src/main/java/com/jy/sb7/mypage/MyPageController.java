package com.jy.sb7.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.sb7.member.MemberVO;
import com.jy.sb7.res.ReservationVO;
import com.jy.sb7.utill.Pager;

@Controller
@RequestMapping(value="/mypage/**")
public class MyPageController {
	
	@Autowired
	private MyPageService mypageService;
	
	@ModelAttribute(name="sub")
	public String getPage() {
		return "reservation";
	}
	
	//예약 내역 리스트 페이징 처리 메서드
	//@GetMapping("reservationList")
	public ModelAndView getList(HttpSession session, Pager pager) throws Exception {
		//로그인 회원 정보를 세션에서 읽어오기
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		//MemberVO memberVO = new MemberVO();
		//memberVO.setId("admin");
		ReservationVO reservationVO = new ReservationVO();
		//reservationVO.setId(memberVO.getId());
		
		pager.setPage(1);
		pager.setSize(4);
		PageInfo<ReservationVO> pageInfo = mypageService.getReservationList(reservationVO, pager);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPageNum());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pager", pager);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("reservation", pageInfo.getList());
		mv.setViewName("mypage/reservationList");
		return mv;
	}
	
	//예약 내역 리스트 불러오는 메서드
	@GetMapping("reservationList")
	public ModelAndView getMemberReservationList(HttpSession session, Pager pager) throws Exception {
		//로그인회원 정보를 세션에서 읽어오기
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		System.out.println(memberVO.getId());
		
		List<ReservationVO> list = mypageService.getMemberReservationList(memberVO);
		
		pager.setPage(1);
		pager.setSize(4);
		PageInfo<ReservationVO> pageInfo = mypageService.getMemberReservationList(memberVO, pager);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPageNum());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pager", pager);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("reservation", pageInfo.getList());
		mv.setViewName("mypage/reservationList");
		return mv;
	}
}
