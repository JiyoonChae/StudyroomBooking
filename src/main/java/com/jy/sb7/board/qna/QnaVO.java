package com.jy.sb7.board.qna;

import java.sql.Date;

import com.jy.sb7.board.BoardVO;

import lombok.Data;

@Data
public class QnaVO {
	private String id;
	private String type;
	private String email;
	private String phone;
	
	private long qnaNum;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
}
