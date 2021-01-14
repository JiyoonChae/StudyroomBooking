package com.jy.sb7.board.faq;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FaqRepositoryRest {

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

}
