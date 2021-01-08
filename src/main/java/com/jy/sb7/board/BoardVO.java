package com.jy.sb7.board;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@MappedSuperclass	//매핑정보만 상속됨
public class BoardVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	private String title;
	private String writer;
	@Column(length = 100000000)
	private String contents;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Date regDate;
	
	private long hit;
	
}
