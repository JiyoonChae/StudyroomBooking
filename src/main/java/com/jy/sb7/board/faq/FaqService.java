package com.jy.sb7.board.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jy.sb7.board.BoardVO;
import com.jy.sb7.utill.Pager;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;
	
	public Page<BoardVO> getSearchList(Pager pager, Pageable pageable) throws Exception {
		String category = pager.getSearchType();
		String keyword = pager.getKeyword();

		if(!category.equals("전체")) {
			return faqRepository.findByCategoryIsAndTitleContainingOrCategoryIsAndContentsContainingOrderByNumDesc(category, keyword, category, keyword, pageable);
		}
		return faqRepository.findByTitleContainingOrContentsContainingOrderByNumDesc(keyword, keyword, pageable);
	}
	

	public FaqVO getOne(FaqVO faqVO) throws Exception {
		return faqRepository.findById(faqVO.getNum()).get();
	}	
	
	public int setUpdate(FaqVO faqVO) throws Exception {
		return faqRepository.setUpdate(faqVO.getCategory(), faqVO.getTitle(), faqVO.getContents(), faqVO.getNum());
	}
	
	public boolean setDelete(FaqVO faqVO) throws Exception {
		long deleteNum = faqVO.getNum();
		faqRepository.deleteById(deleteNum);
		
		if(faqRepository.findById(deleteNum).isEmpty()) {
			return true;
		}
		return false;
	}
	
	public FaqVO setInsert(FaqVO faqVO) throws Exception {
		return faqRepository.save(faqVO);
	}
	
}
