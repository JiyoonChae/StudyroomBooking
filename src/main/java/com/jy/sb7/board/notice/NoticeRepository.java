package com.jy.sb7.board.notice;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NoticeRepository extends JpaRepository<NoticeVO, Long> {

	@Modifying
	@Transactional
	@Query("update NoticeVO N set N.hit=:hit where num=:num")
	public int setUpdateHit(long hit, long num);
	
	@Modifying
	@Transactional
	@Query("update NoticeVO N set N.title=:title, N.contents=:contents where num=:num")
	public int setUpdate(String title, String contents, long num);
	
	//select * from notice where num > (num) order by num desc;
	public Page<NoticeVO> findByNumGreaterThanOrderByNumDesc(long num, Pageable pageable);
	
//	@Modifying
//	@Transactional
//	@Query("select count() from NoticeVO N where N.num=:num")
//	public int getCheckCount(long num);
}
