package com.jy.sb7.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private long hit;
}
