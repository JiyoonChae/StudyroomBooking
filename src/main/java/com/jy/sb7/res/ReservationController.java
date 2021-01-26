package com.jy.sb7.res;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.member.MemberVO;
import com.jy.sb7.res.pay.PayService;
import com.jy.sb7.res.pay.PayVO;
import com.jy.sb7.room.StudyRoomsVO;

@Controller
@RequestMapping("/res/**")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private PayService payService;
	
	//예약 페이지 연결
	@GetMapping("roomRes")
	public ModelAndView setRes() throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("예약 컨트롤러 진입");
		
		mv.setViewName("reservation/roomRes");
		return mv;
	}
	
	//예약 확정 페이지
	@GetMapping("resConfirm")
	public ModelAndView getResPage(ReservationVO resVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO =(MemberVO)session.getAttribute("member");
		
		StudyRoomsVO sVO = new StudyRoomsVO();
		System.out.println("받은 예약번호: "+ resVO.getRevNum());
		MemberVO resInfo = reservationService.getResInfo(resVO);
		PayVO payVO= payService.getPayInfo(resVO);
		System.out.println("컨트롤러ID :"+resInfo.getId());
		System.out.println("email :" +resInfo.getEmail());
		System.out.println("price :" +resInfo.getResVO().getRoomPrice());
		mv.addObject("resInfo", resInfo);
		mv.addObject("room", resInfo.getResVO().getStudyRoomsVO());
		mv.addObject("member", memberVO);
		mv.addObject("pay", payVO);
		mv.setViewName("reservation/resConfirm");
		return mv;
	}
	
	//예약 확정 (모달창) 정보 받는 메서드
	@PostMapping("roomConfirm")
	public ModelAndView roomConfirm(MemberVO memberVO, ReservationVO resVO, HttpSession session) throws Exception{
		ModelAndView mv= new ModelAndView();
		System.out.println("예약 정보 insert controller------------------------");
		MemberVO user =(MemberVO)session.getAttribute("member");
		
		memberVO.setId(user.getId());  //DB에 저장할 로그인한 아이디
		memberVO.setEmail(user.getEmail()); //DB에 저장할 로그인한 이메일
		System.out.println("예약번호:" +resVO.getRevNum());
		System.out.println("예약금액: "+resVO.getRoomPrice());

		 memberVO.setResVO(resVO); //DB에 저장할 새로운 예약 정보
		int result = reservationService.roomConfirm(memberVO);
		System.out.println("result : " + result );
		
		if(result >0) {
			System.out.println("예약 정보 db 저장 완료");
		}
		mv.addObject("msg", result);
		mv.setViewName("common/result");
		
		return mv;
	}
}
