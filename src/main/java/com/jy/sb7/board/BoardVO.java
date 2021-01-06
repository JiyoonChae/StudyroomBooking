package com.jy.sb7.board;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:MM:SS")
	private LocalDateTime regDate;
	
	private long hit;
	
}
