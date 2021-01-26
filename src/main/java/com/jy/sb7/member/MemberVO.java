package com.jy.sb7.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jy.sb7.res.ReservationVO;

import lombok.Data;

@Data
public class MemberVO {
	private long num;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private long adminNum;
	private long type;
	private String joinPath; //kakao, naver
	private Date joinDate;
	
	private List<ReservationVO> reservationVO;
	private ReservationVO resVO;
	
	
	public String getName() {
		if(this.name == null) {
			this.name="name";
		}
		return name;
	}
	public void setName(String name) {
		if(this.name==null) {
			this.name="name";
		}
		this.name = name;
	}
	
	
	
}
