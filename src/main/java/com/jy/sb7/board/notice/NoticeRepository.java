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
//	@Query("select N from NoticeVO N where N.title LIKE %:search% OR N.contents LIKE %:search%")
//	public Page<NoticeVO> findAllSearch(String search, Pageable pageable);

	//select * from notice where title like '%search%' or contents like '%search%' order by num desc;
//	@Modifying
//	@Transactional
//	@Query(
//			nativeQuery = true,
//			value="select * from notice where title like %:search% or contents like %:search% order by num desc",
//			countQuery="select count(*) from notice where title like %:search% or contents like %:search%"
//	)
//	public Page<NoticeVO> findByTitleContainingOrContentsContainingOrderByNumDesc(String search, Pageable pageable);
}
