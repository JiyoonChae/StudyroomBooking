package com.jy.sb7.res.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.res.ReservationVO;

@Controller
@RequestMapping("/pay/**")
public class PayController {
	@Autowired
	private PayService payService;
	
	@PostMapping("payComplete")
	public ModelAndView setPaymentInsert(PayVO payVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("pay controlloer까지 옴 -----------");
		System.out.println("예약번호: "+payVO.getRevNum());
		System.out.println("결제할금액: "+ payVO.getAmount());
		System.out.println("결제번호" +payVO.getMerchant_uid());
		System.out.println("pg: " +payVO.getPg_provider());
		System.out.println("결제한금액: "+payVO.getPaid_amount());
		System.out.println("결제방법: "+payVO.getPay_method());
		System.out.println("결제상태 " +payVO.getStatus());
		//결제 하고 결제 테이블에 넣고 
		int result = payService.setPaymentInsert(payVO);
		if(result >0) {
			System.out.println("결제 후 db저장 완료");
		}
		// 예약된 정보를 예약 테이블에도 넣어야하는데..?
		mv.addObject("msg", result);
		mv.setViewName("common/result");
		
		return mv;
	}
}
