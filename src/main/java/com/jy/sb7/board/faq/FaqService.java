package com.jy.sb7.board.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;
	
	public Page<FaqVO> getList(Pageable pageable) throws Exception {
		return faqRepository.findAll(pageable);
	}
	
	public FaqVO setInsert(FaqVO faqVO) throws Exception {
		return faqRepository.save(faqVO);
	}
}
