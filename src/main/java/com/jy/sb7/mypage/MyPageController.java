package com.jy.sb7.mypage;

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
	
	@GetMapping("reservationList")
	public ModelAndView getList(HttpSession session, Pager pager) throws Exception {
		//MemberVO memberVO = (MemberVO)session.getAttribute("member");
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin");
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setId(memberVO.getId());
		
		PageInfo<ReservationVO> pageInfo = mypageService.getReservationList(reservationVO, pager);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getList().get(1));
		System.out.println(pageInfo.getPageNum());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pager", pager);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("reservation", pageInfo.getList());
		mv.setViewName("mypage/reservationList");
		return mv;
	}
}
