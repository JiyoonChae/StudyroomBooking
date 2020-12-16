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
	private String joinPath;
	private Date joinDate;
}
