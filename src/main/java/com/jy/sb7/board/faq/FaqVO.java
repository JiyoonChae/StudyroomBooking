package com.jy.sb7.board.faq;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jy.sb7.board.BoardVO;

import lombok.Data;

@Data
@Entity
@Table(name="faq")
public class FaqVO extends BoardVO {

}
