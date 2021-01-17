package com.jy.sb7.board.faq;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jy.sb7.board.BoardVO;

public interface FaqRepository extends JpaRepository<FaqVO, Long> {
	
	//select * from faq where num > ? order by num desc;
	public Page<BoardVO> findByNumGreaterThanOrderByNumDesc(long num, Pageable pageable);
	
	//select * from faq where title like '%?%' or contents like '%?%' order by num desc;
	public Page<BoardVO> findByTitleContainingOrContentsContainingOrderByNumDesc(String title, String contents, Pageable pageable);
	
	//select * from faq where category like '%?%' and title like '%?%' or category like '%?%' and contents like '%스페이스%' order by num desc;
	public Page<BoardVO> findByCategoryIsAndTitleContainingOrCategoryIsAndContentsContainingOrderByNumDesc(String category1, String title, String category, String contents, Pageable pageable);

	@Modifying
	@Transactional
	@Query("update FaqVO F set F.category=:category, F.title=:title, F.contents=:contents where num=:num")
	public int setUpdate(String category, String title, String contents, long num);
}
