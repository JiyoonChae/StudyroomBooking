package com.jy.sb7.res;


import java.sql.Date;

import com.jy.sb7.member.MemberVO;
import com.jy.sb7.room.StudyRoomsVO;

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
	private Date bookDate;
	
	private StudyRoomsVO studyRoomsVO;
}
