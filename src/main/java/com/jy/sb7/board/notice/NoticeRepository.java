package com.jy.sb7.board.notice;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jy.sb7.board.BoardVO;

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
	//public Page<NoticeVO> findByNumGreaterThanOrderByNumDesc(long num, Pageable pageable);
	public Page<BoardVO> findByNumGreaterThanOrderByNumDesc(long num, Pageable pageable);
	
	//select * from notice where title like '%?%' order by num desc;
	public Page<BoardVO> findByTitleContainingOrderByNumDesc(String search, Pageable pageable);
	
	//select * from notice where contents like '%?%' order by num desc;
	public Page<BoardVO> findByContentsContainingOrderByNumDesc(String search, Pageable pageable);

	//select * from notice where title like '%?%' or contents like '%?%' order by num desc;
	public Page<BoardVO> findByTitleContainingOrContentsContainingOrderByNumDesc(String title, String contents, Pageable pageable);
	
	
	
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
