package com.jy.sb7.res.pay;

import org.apache.ibatis.annotations.Mapper;

import com.jy.sb7.res.ReservationVO;

@Mapper
public interface PayMapper {
	//결제 정보 저장
	public int setPaymentInsert(PayVO payVO) throws Exception;
	//결제 정보 조회
	public PayVO getPayInfo(ReservationVO resVO) throws Exception;
}
