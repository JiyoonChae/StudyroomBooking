package com.jy.sb7.board.notice;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NoticeFileRepository extends JpaRepository<NoticeFileVO, Long> {

	/*
	 * @Modifying
	 * @Transactional
	 * @Query("select * from NoticeFileVO NF where NF.fileNum=:fileNum") 
	 * public NoticeFileVO getFileOne(long fileNum);
	 */
}
