package com.jy.sb7.res.pay;

import org.apache.ibatis.annotations.Mapper;

import com.jy.sb7.res.ReservationVO;

@Mapper
public interface PayMapper {
	
	public int setPaymentInsert(PayVO payVO) throws Exception;
	
	public PayVO getPayInfo(ReservationVO resVO) throws Exception;
}
