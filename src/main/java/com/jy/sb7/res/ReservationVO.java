package com.jy.sb7.res;


import com.jy.sb7.member.MemberVO;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data 
public class ReservationVO extends MemberVO{
	private long revNum;
	private long startTime;
	private long endTime;
	private int roomTime;
	private int roomUser;
	private String roomDate;
	private int roomType;
	private int roomPrice;
	private String payment;
	

}
