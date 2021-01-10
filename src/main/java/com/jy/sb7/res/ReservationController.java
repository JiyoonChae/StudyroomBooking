package com.jy.sb7.res;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/res/**")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("roomRes")
	public String setRes() throws Exception{
		return "reservation/roomRes";
	}
	@GetMapping("resConfirm")
	public String confirmRes() throws Exception{
		return "reservation/resConfirm";
	}
	@PostMapping("roomConfirm")
	public void roomConfirm(ReservationVO reservationVO, HttpSession session) throws Exception{
		ReservationVO user =(ReservationVO)session.getAttribute("member");
		
		reservationVO.setId(user.getId());
		reservationVO.setEmail(user.getEmail());
		int result = reservationService.roomConfirm(reservationVO);
		System.out.println("result : " + result );
	}
}
