package com.jy.sb7.admin.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.res.ReservationVO;

@Controller
@RequestMapping(value="/admin/reservation/**")
public class AdminReservationController {

	@Autowired
	private AdminReservationService adminReservationService;
	
	
	@GetMapping("reservationList")
	public ModelAndView getAdminReservationList() throws Exception {
		List<ReservationVO> list = adminReservationService.getReservationList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("admin/reservation/reservationList");
		return mv;
	}
}
