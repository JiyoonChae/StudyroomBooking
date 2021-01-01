package com.jy.sb7.board.notice;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jy.sb7.board.BoardVO;

import lombok.Data;

@Data
@Entity
@Table(name="notice")
public class NoticeVO extends BoardVO {
	
}
