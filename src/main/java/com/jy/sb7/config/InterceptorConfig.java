package com.jy.sb7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jy.sb7.interceptor.FaqAdminInterceptor;
import com.jy.sb7.interceptor.NoticeAdminInterceptor;
import com.jy.sb7.interceptor.ReservationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private NoticeAdminInterceptor noticeAdminInterceptor;
	@Autowired
	private FaqAdminInterceptor faqAdminInterceptor;
	
	@Autowired
	private ReservationInterceptor reservationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//게시판글 작성/수정/삭제는 관리자만 가능
		//적용할 Interceptor를 registry에 등록
		registry.addInterceptor(noticeAdminInterceptor)
		//Interceptor에서 사용할 URL 작성
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeUpdate")
		.addPathPatterns("/notice/noticeDelte");

		registry.addInterceptor(faqAdminInterceptor)
		//Interceptor에서 사용할 URL 작성
		.addPathPatterns("/faq/faqWrite")
		.addPathPatterns("/faq/faqUpdate")
		.addPathPatterns("/faq/faqDelte");
		
		registry.addInterceptor(reservationInterceptor)
		.addPathPatterns("/res/**"); 
		
	}
}
