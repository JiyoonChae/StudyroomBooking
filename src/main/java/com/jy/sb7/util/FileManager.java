package com.jy.sb7.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public String saveUUIDFileCopy(MultipartFile multipartFile, File file) throws Exception {
		
		String fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
	
	public String saveUUIDTransferTo(MultipartFile multipartFile, File file) throws Exception {
		
		String fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		multipartFile.transferTo(file);
		
		System.out.println("saveUUIDTransferTo 파일명 : " + fileName);
		return fileName;
	}
	
	public String saveCalenderTransferTo(MultipartFile multipartFile, File file) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		
		String fileName = calendar.getTimeInMillis()+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		multipartFile.transferTo(file);
		
		return fileName;
	}
}
