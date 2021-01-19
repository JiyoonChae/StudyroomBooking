package com.jy.sb7.board.faq;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jy.sb7.board.BoardVO;
import com.jy.sb7.board.notice.NoticeVO;
import com.jy.sb7.utill.Pager;

@SpringBootTest
class FaqRepositoryTest {

	@Autowired
	private FaqRepository faqRepository;
	
	//@Test
	void saveTest() throws InterruptedException {
		for(int i=0; i<50; i++) {
			FaqVO faqVO = new FaqVO();
			faqVO.setCategory("테스트");
			faqVO.setTitle("질문"+i);
			faqVO.setContents("답변"+i);
			faqVO.setWriter("작성자"+i);
			faqRepository.save(faqVO);
			
			if(i%10==0) { Thread.sleep(500); }
		}
		assertNotNull(faqRepository.findAll());		
	}
	
	//@Test
	void listTest() {
		List<FaqVO> list = faqRepository.findAll();
		
		for(FaqVO faqVO : list) {
			System.out.println(faqVO.getNum());
			System.out.println(faqVO.getCategory());
			System.out.println(faqVO.getTitle());
			System.out.println(faqVO.getWriter());
			System.out.println(faqVO.getContents());
			System.out.println("--------------------");
		}		
		assertNotNull(list);
	}

	//@Test
	void allSearchTest() {
		Pager pager = new Pager();
		pager.setSearchType("기타");
		pager.setKeyword(".");
		
		Pageable pageable = PageRequest.of(0, 10);
		Page<BoardVO> page = faqRepository.findByTitleContainingOrContentsContainingOrderByNumDesc(pager.getKeyword(), pager.getKeyword(), pageable);
		
		if(page.hasContent()) {
			List<BoardVO> faqList = page.getContent();
			
			for(BoardVO boardVO : faqList) {
				FaqVO faqVO = (FaqVO)boardVO;
				System.out.println(faqVO.getNum());
				System.out.println(faqVO.getCategory());
				System.out.println(faqVO.getTitle());
				System.out.println(faqVO.getWriter());
				System.out.println(faqVO.getContents());
				System.out.println("---------------------");
			}
		}
		
		assertNotNull(page.getContent());
	}
	
	
	//@Test
	void categorySearchTest() {
		Pager pager = new Pager();
		pager.setSearchType("취소");
		pager.setKeyword("현금");

		Pageable pageable = PageRequest.of(0, 10);
		Page<BoardVO> page = faqRepository.findByCategoryIsAndTitleContainingOrCategoryIsAndContentsContainingOrderByNumDesc(pager.getSearchType(), pager.getKeyword(), pager.getSearchType(), pager.getKeyword(), pageable);

		if(page.hasContent()) {
			List<BoardVO> faqList = page.getContent();

			for(BoardVO boardVO : faqList) {
				FaqVO faqVO = (FaqVO)boardVO;
				System.out.println(faqVO.getNum());
				System.out.println(faqVO.getCategory());
				System.out.println(faqVO.getTitle());
				System.out.println(faqVO.getWriter());
				System.out.println(faqVO.getContents());
				System.out.println("---------------------");
			}
		}

		assertNotNull(page.getContent());
	}
}
