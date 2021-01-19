package com.jy.sb7.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jy.sb7.board.BoardVO;
import com.jy.sb7.utill.FileManager;
import com.jy.sb7.utill.FilePathGenerator;
import com.jy.sb7.utill.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private NoticeFileRepository NoticeFileRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;		//파일을 저장할 디렉터리
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.notice.filePath}")
	private String filePath;							//파일 저장 디렉터리명 받아오기
	
	
	public int setUpdateHit(NoticeVO noticeVO) throws Exception {
		return noticeRepository.setUpdateHit(noticeVO.getHit(), noticeVO.getNum());
	}
	
	public NoticeVO getOne(NoticeVO noticeVO) throws Exception {
		Optional<NoticeVO> optional = noticeRepository.findById(noticeVO.getNum());
		return optional.get();
	}
	
	public NoticeFileVO getFileDown(NoticeFileVO noticeFileVO) throws Exception {
		Optional<NoticeFileVO> optional = NoticeFileRepository.findById(noticeFileVO.getFileNum());
		return optional.get();
	}
	
	/* 파일 업로드 insert */
//	public void setInsert(NoticeVO noticeVO, MultipartFile[] files) throws Exception {	
//		noticeVO = noticeRepository.save(noticeVO);
//		
//		File file = filePathGenerator.getUseResourceLoader(filePath);
//		System.out.println("Notice File : " + file.getAbsolutePath());
//		
//		List<NoticeFileVO> noticeFileList = new ArrayList<NoticeFileVO>();
//		
//		for(MultipartFile multipartFile : files) {
//			if(multipartFile.getSize()==0) {
//				continue;
//			}
//			
//			String fileName = fileManager.saveUUIDTransferTo(multipartFile, file);
//			
//			NoticeFileVO noticeFileVO = new NoticeFileVO();
//			noticeFileVO.setFileName(fileName);
//			noticeFileVO.setOriName(multipartFile.getOriginalFilename());
//			noticeFileVO.setNoticeVO(noticeVO);
//			
//			noticeFileList.add(noticeFileVO);
//		}
//		noticeVO.setNoticeFileVOs(noticeFileList);
//		noticeRepository.save(noticeVO);
//	}
	
	/* summernote insert*/
	public NoticeVO setInsert(NoticeVO noticeVO) throws Exception {
		System.out.println("Summernote Insert");
		return noticeRepository.save(noticeVO);
	}
	
	
	public Page<BoardVO> getList(Pageable pageable) throws Exception {
		return noticeRepository.findByNumGreaterThanOrderByNumDesc(0L, pageable);
	}
	
	public Page<BoardVO> getSearchList(Pager pager, Pageable pageable) throws Exception {
		String searchType = pager.getSearchType();
		String keyword = pager.getKeyword();
		
		if(searchType.equals("title")) {
			return noticeRepository.findByTitleContainingOrderByNumDesc(keyword, pageable);
		} else if(searchType.equals("contents")) {
			return noticeRepository.findByContentsContainingOrderByNumDesc(keyword, pageable);
		}
		return noticeRepository.findByTitleContainingOrContentsContainingOrderByNumDesc(keyword, keyword, pageable);
	}
	
	
	public int setUpdate(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
		return noticeRepository.setUpdate(noticeVO.getTitle(), noticeVO.getContents(), noticeVO.getNum());
	}
	
	public boolean setDelete(NoticeVO noticeVO) throws Exception {
		long deleteNum = noticeVO.getNum();
		noticeRepository.deleteById(deleteNum);
		
		boolean result = false;
		System.out.println("삭제할 번호 : "+noticeRepository.findById(deleteNum));
		if( noticeRepository.findById(deleteNum).isEmpty()) {
			result = true;
		}
		System.out.println("삭제 결과 : " + result);
		return result;
	}
	
}
