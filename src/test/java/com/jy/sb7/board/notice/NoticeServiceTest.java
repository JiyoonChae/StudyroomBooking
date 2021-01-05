package com.jy.sb7.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class NoticeServiceTest {

	@Autowired
	private NoticeService noticeService;
	

	//@Test
	void setInsertTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("Title Test 2");
		noticeVO.setWriter("Writer Test 2");
		noticeVO.setContents("Contents Test 2");
		
	}
}
