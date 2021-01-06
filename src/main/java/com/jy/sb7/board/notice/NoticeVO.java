package com.jy.sb7.board.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jy.sb7.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="notice")
public class NoticeVO extends BoardVO {
	
	//LAZY : 해당 리스트가 필요할 시 select join 진행
	//@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)	//참조
	//private List<NoticeFileVO> noticeFileVOs;
	
}
