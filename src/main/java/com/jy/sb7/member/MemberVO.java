package com.jy.sb7.member;

import java.sql.Date;

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
