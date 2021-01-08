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

import com.jy.sb7.utill.FileManager;
import com.jy.sb7.utill.FilePathGenerator;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
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
	
	public void setInsert(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
		System.out.println("NoticeVO + MultipartFile Insert");
		noticeVO = noticeRepository.save(noticeVO);
		System.out.println("Notice Insert --- Num : " + noticeVO.getNum());
		
		File file = filePathGenerator.getUseResourceLoader(filePath);
		System.out.println("Notice Insert --- File : " + file.getAbsolutePath());
		
		List<NoticeFileVO> noticeFileList = new ArrayList<NoticeFileVO>();
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			
			String fileName = fileManager.saveUUIDTransferTo(multipartFile, file);
			
			NoticeFileVO noticeFileVO = new NoticeFileVO();
			noticeFileVO.setFileName(fileName);
			noticeFileVO.setOriName(multipartFile.getOriginalFilename());
			noticeFileVO.setNoticeVO(noticeVO);
			
			noticeFileList.add(noticeFileVO);
		}
		
		//noticeVO.setNoticeFileVOs(noticeFileList);
		noticeRepository.save(noticeVO);
	}
	
	public NoticeVO setInsert(NoticeVO noticeVO) throws Exception {
		System.out.println("NoticeVO insert");
		return noticeRepository.save(noticeVO);
	}
	
	public List<NoticeVO> getList() throws Exception {
		return noticeRepository.findAll();
	}
	
	public Page<NoticeVO> getList(Pageable pageable) throws Exception {
		return noticeRepository.findByNumGreaterThanOrderByNumDesc(0L, pageable);
	}
}
