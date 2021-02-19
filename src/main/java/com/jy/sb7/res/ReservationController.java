package com.jy.sb7.res;

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
		resVO = reservationService.getResInfo(resVO);
		PayVO payVO= payService.getPayInfo(resVO);
		//System.out.println("컨트롤러ID :"+resVO.getId());
		//System.out.println("email :" +resVO.getEmail());
		//System.out.println("price :" +resVO.getRoomPrice());
		mv.addObject("resInfo", resVO);
		mv.addObject("room", resVO.getStudyRoomsVO());
		mv.addObject("member", memberVO);
		mv.addObject("pay", payVO);
		mv.setViewName("reservation/resConfirm");
		return mv;
	}
	
	//예약 확정 (모달창) 정보 받는 메서드
	@PostMapping("roomConfirm")
	public ModelAndView roomConfirm(ReservationVO reservationVO, HttpSession session) throws Exception{
		ModelAndView mv= new ModelAndView();
		System.out.println("예약 정보 insert controller------------------------");
		MemberVO user =(MemberVO)session.getAttribute("member");
		
		//reservationVO.setId(user.getId());
		//reservationVO.setEmail(user.getEmail());
		int result = reservationService.roomConfirm(reservationVO);
		System.out.println("result : " + result );
		
		if(result >0) {
			System.out.println("예약 정보 db 저장 완료");
		}
		mv.addObject("msg", result);
		mv.setViewName("common/result");
		
		return mv;
	}
}
