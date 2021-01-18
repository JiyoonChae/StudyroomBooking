package com.jy.sb7.board.qna;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QnaFileRepository {

	  @Modifying
	  @Transactional
	  @Query("select * from QnaFileVO QF where QF.fileNum=:fileNum") 
	  public QnaFileVO getFileOne(long fileNum);
	 
}
