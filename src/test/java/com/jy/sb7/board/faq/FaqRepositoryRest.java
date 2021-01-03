package com.jy.sb7.board.faq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FaqRepositoryRest {

	@Autowired
	private FaqRepository faqRepository;
	
	@Test
	void saveTest() {
		
	}
	
	@Test
	void listTest() {
		fail("Not yet implemented");
	}

}
