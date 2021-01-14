package com.jy.sb7.res.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.sb7.res.ReservationVO;

@Service
public class PayService {
	@Autowired
	private PayMapper payMapper;
	
	public PayVO getPayInfo(ReservationVO resVO) throws Exception{
		return payMapper.getPayInfo(resVO);
	}
	
	public int setPaymentInsert(PayVO payVO) throws Exception{
		return payMapper.setPaymentInsert(payVO);
	}
}
