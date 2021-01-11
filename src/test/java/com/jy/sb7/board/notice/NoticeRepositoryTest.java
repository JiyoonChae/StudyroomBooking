package com.jy.sb7.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	
	//@Test
	void deleteByIdTest() throws Exception {
		noticeRepository.deleteById(119L);
		
		assertNull(noticeRepository.findById(71L).get());
	}
	
	//@Test
	void deleteTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(70);
		noticeRepository.delete(noticeVO);
		
		assertNull(noticeRepository.findById(70L).get());
	}
	
	//@Test
	void findTest() throws Exception {
		Optional<NoticeVO> optional = noticeRepository.findById(102L);
		NoticeVO noticeVO = optional.get();
		
		System.out.println(noticeVO.getNum());
		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getRegDate());
		System.out.println(noticeVO.getHit());
		
		assertNotNull(noticeVO);
	}
	
	
	//@Test
	void saveTest() throws Exception {
		/* 테스트 데이터 생성 */
		for(int i=0; i<100; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("Title " + i);
			noticeVO.setContents("Contents " + i);
			noticeVO.setWriter("Wrtier " + i);
			noticeVO = noticeRepository.save(noticeVO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
	}
	
	
	//@Test
	void saveFileTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("Title + File - Test 2");
		noticeVO.setContents("Contents + File - Test 2");
		noticeVO.setWriter("Wrtier + File - Test ");
		noticeVO = noticeRepository.save(noticeVO);
		
		List<NoticeFileVO> fileList = new ArrayList<>();
		NoticeFileVO noticeFileVO = new NoticeFileVO();
		noticeFileVO.setFileName("FileName Test 2-1");
		noticeFileVO.setOriName("OriName Test 2-1");
		noticeFileVO.setNoticeVO(noticeVO);
		fileList.add(noticeFileVO);
		
		NoticeFileVO noticeFileVO2 = new NoticeFileVO();
		noticeFileVO2.setFileName("FileName Test 1-2");
		noticeFileVO2.setOriName("OriName Test 1-2");
		noticeFileVO2.setNoticeVO(noticeVO);
		fileList.add(noticeFileVO2);
		
		//noticeVO.setNoticeFileVOs(fileList);
		noticeRepository.save(noticeVO);
	}
	
	
	//@Test
	void countTest() {
		long count = noticeRepository.count();
		System.out.println("count : " + count);
		
		assertNotEquals(0, count);
	}
	
	//@Test
	void listTest() {
		List<NoticeVO> list = noticeRepository.findAll();
		
		for(NoticeVO noticeVO : list) {
			System.out.println(noticeVO.getNum());
			System.out.println(noticeVO.getTitle());
			System.out.println(noticeVO.getWriter());
			System.out.println(noticeVO.getContents());
			System.out.println("---------------------");
		}
		
		assertNotNull(list);
	}
	
	//@Test
	void pageableListTest() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<NoticeVO> page = noticeRepository.findAll(pageable);
		
		if(page.hasContent()) {
			List<NoticeVO> noticeList = page.getContent();
			
			for(NoticeVO noticeVO : noticeList) {
				System.out.println(noticeVO.getNum());
				System.out.println(noticeVO.getTitle());
				System.out.println(noticeVO.getWriter());
				System.out.println(noticeVO.getContents());
				System.out.println("---------------------");
			}
		}
		
		assertNotNull(page.getContent());
	}

}
