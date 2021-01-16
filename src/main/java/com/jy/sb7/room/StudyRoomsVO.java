package com.jy.sb7.room;

import com.jy.sb7.res.ReservationVO;

import lombok.Data;

@Data
public class StudyRoomsVO{

	private long roomNum;
	private String roomName;
	private long min;
	private long max;
	private String fileUrl;
	private String oriName;
	
}
