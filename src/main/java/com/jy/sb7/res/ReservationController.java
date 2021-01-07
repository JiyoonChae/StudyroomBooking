package com.jy.sb7.res;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/res/**")
public class ReservationController {
	
	@GetMapping("roomRes")
	public String setRes() throws Exception{
		return "reservation/roomRes";
	}
	@GetMapping("resConfirm")
	public String confirmRes() throws Exception{
		return "reservation/resConfirm";
	}
}
