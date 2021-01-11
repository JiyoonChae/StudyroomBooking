package com.jy.sb7.utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.jy.sb7.board.notice.NoticeFileVO;

@Component
public class FileDown extends AbstractView {

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("File Down View");
		
		//1. 파일이 저장된 폴더까지 경로
		String filePath = "classpath:/static/" + (String)model.get("filePath");
		System.out.println(filePath);
		
		//2. 저장된 파일명까지 설정
		NoticeFileVO noticeFileVO = (NoticeFileVO)model.get("noticeFileVO");
		filePath = filePath + "/" + noticeFileVO.getFileName();
		System.out.println(filePath);
		
		//3. 위의 정보를 이용해서 File 객체 생성
		File file = resourceLoader.getResource(filePath).getFile();
		
		//4. 한글처리
		response.setCharacterEncoding("UTF-8");
		
		//5. 총 파일의 크기
		response.setContentLengthLong(file.length());
		
		//6. 다운로드 시 파일 이름 인코딩 처리
		String fileName = URLEncoder.encode(noticeFileVO.getOriName(), "UTF-8");
		
		//7. header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//8. HDD에 파일을 연결
		FileInputStream in = new FileInputStream(file);
		
		//9. Client 전송 준비
		OutputStream out = response.getOutputStream();
		
		//10. 전송
		FileCopyUtils.copy(in, out);
		
		//11. 자원해제
		out.close();
		in.close();
		
	}

}
