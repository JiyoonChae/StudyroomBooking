package com.jy.sb7.res.pay;

import lombok.Data;

@Data
public class PayVO {
	//pk, 주문번호, 결제소스, 결제방법, uid, 지불할 금액, 구매자 연락처, 결제한 금액, 상태
	private long payNum;
	private long revNum;  //주문번호 = 예약
	private String pg_provider;
	private String pay_method;
	private String merchant_uid;
	private long amount;
	//private String buyer_tel;
	private long paid_amount;
	private String status;
	private String orderDate;

	
}
