package com.jy.sb7.board.qna;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.jy.sb7.board.BoardVO;

import lombok.Data;

@Data
@Entity
@Table(name="qna")
public class QnaVO {
	
	@Column(updatable = false)
	private String id;
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	@NotEmpty
	private String title;
	@Lob
	@Column(length = 100000000)
	private String contents;
	private String category;
	private String state;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Date regDate;
	
	@UpdateTimestamp
	private Date updateDate;
	
	@OneToMany(mappedBy = "qnaVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<QnaFileVO> qnaFileVOs;
}
