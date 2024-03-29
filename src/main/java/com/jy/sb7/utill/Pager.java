package com.jy.sb7.utill;

import org.springframework.data.domain.Page;

import com.jy.sb7.board.BoardVO;
import com.jy.sb7.board.faq.FaqVO;
import com.jy.sb7.board.notice.NoticeVO;

import lombok.Data;

@Data
public class Pager {

	private Integer page;
	private Integer size;
	
	private int startNum;
	private int lastNum;
	
	private boolean isPrev;
	private boolean isNext;
	
	private String searchType;
	private String keyword;
	
	
	
	public Integer getPage() {
		if(this.page == null) {
			this.page = 0;
		}
		return page;
	}
	public void setPage(Integer page) {
		if(page == null) {
			page = 0;
		}
		this.page = page;
	}
	
	public Integer getSize() {
		if(this.size == null || this.size == 0) {
			this.size = 10;
		}
		return size;
	}
	public void setSize(Integer size) {
		if(size == null || size == 0) {
			size = 10;
		}
		this.size = size;
	}
	
	
	public String getSearchType() {
		if(this.searchType == null) {
			this.searchType = "all";
		}
		return this.searchType;
	}
	public void setSearchType(String searchType) {
		if(searchType == null) {
			searchType = "all";
		}
		this.searchType = searchType;
	}
	
	public String getKeyword() {
		System.out.println("저장된 검색어 : " + this.keyword);
		if(keyword == null) {
			keyword = "";
		}
		System.out.println("반환할 검색어 : " + this.keyword);
		return keyword;
	}
	public void setKeyword(String keyword) {
//		System.out.println("넘어온 검색어 : " + keyword);
//		if(keyword == null) {
//			keyword = "";
//		}
		this.keyword = keyword;
	}
	
	
	
	public void makePage(Page<BoardVO> page) {
		//1. totalCount로 totalPage 계산
		//2. totalPage로 totalBlock 계산
		int blockSize = 5;
		int totalBlock = page.getTotalPages() / blockSize;
		if( page.getTotalPages() % blockSize != 0 ) {
			totalBlock++;
		}
		
		//3. 현재 페이지번호로 현재 블럭번호 계산
		int curBlock = (page.getNumber()+1) / blockSize;
		if( (page.getNumber()+1) % blockSize != 0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호로 블럭의 startNum, lastNum 계산
		this.startNum = (curBlock-1) * blockSize +1;
		this.lastNum = curBlock * blockSize;
		
		//5. 현재 블럭이 마지막 블럭과 같다면 lastNum 수정 및 next 버튼 비활성화
		isNext = true;
		if(curBlock == totalBlock) {
			lastNum = page.getTotalPages();
			isNext = false;
		}
		
		//6. 이전블럭 유무 계산
		isPrev = false;
		if(curBlock > 1) {
			isPrev = true;
		}
	}

	
	public void makePage(Page<FaqVO> faqPage, int blockSize) {
		//1. totalCount로 totalPage 계산
		//2. totalPage로 totalBlock 계산
		//int blockSize = 5;
		int totalBlock = faqPage.getTotalPages() / blockSize;
		if( faqPage.getTotalPages() % blockSize != 0 ) {
			totalBlock++;
		}
		
		//3. 현재 페이지번호로 현재 블럭번호 계산
		int curBlock = (faqPage.getNumber()+1) / blockSize;
		if( (faqPage.getNumber()+1) % blockSize != 0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호로 블럭의 startNum, lastNum 계산
		this.startNum = (curBlock-1) * blockSize +1;
		this.lastNum = curBlock * blockSize;
		
		//5. 현재 블럭이 마지막 블럭과 같다면 lastNum 수정 및 next 버튼 비활성화
		isNext = true;
		if(curBlock == totalBlock) {
			lastNum = faqPage.getTotalPages();
			isNext = false;
		}
		
		//6. 이전블럭 유무 계산
		isPrev = false;
		if(curBlock > 1) {
			isPrev = true;
		}
	}
}
