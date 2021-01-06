package com.jy.sb7.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jy.sb7.util.FileManager;
import com.jy.sb7.util.FilePathGenerator;

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
}
