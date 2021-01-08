package com.jy.sb7.utill;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private ServletContext servletContext;
	
	
	public File getUseResourceLoader(String filePath) throws Exception {
		
		String defaultPath = "classpath:/static/";
		
		resourceLoader.getResource(defaultPath);
		System.out.println("ResourceLoader : "+resourceLoader.getResource(defaultPath));
		
		File file = new File(resourceLoader.getResource(defaultPath).getFile(), filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	
	public File getUseClassPathResource(String filePath) throws Exception {
		//시작 경로에서 classpath 제외
		String defaultPath = "static";
		
		ClassPathResource classPathResource = new ClassPathResource(defaultPath);
		System.out.println("ClassPathResource : "+classPathResource.getFile());
		
		File file = new File(classPathResource.getFile(), filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	
}
