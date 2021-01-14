package com.jy.sb7.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaRepository qnaRepository;
	
	public QnaVO setInsert(QnaVO qnaVO) throws Exception {
		return qnaRepository.save(qnaVO);
	}
}
