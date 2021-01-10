package com.jy.sb7.res;

import com.jy.sb7.member.MemberVO;

import lombok.Data;

@Data 
public class ReservationVO extends MemberVO {
	private int revNum;
	private int startTime;
	private int endTime;
	private int roomTime;
	private int roomUser;
	private String roomDate;
	private int roomType;
	private int roomPrice;
	private String payment;
	
}
