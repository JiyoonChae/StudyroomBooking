package com.jy.sb7.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jy.sb7.board.faq.FaqRepository;
import com.jy.sb7.board.faq.FaqVO;
import com.jy.sb7.board.notice.NoticeVO;
import com.jy.sb7.member.MemberVO;

@Component
public class FaqAdminInterceptor implements HandlerInterceptor {
	
	@Autowired
	private FaqRepository faqReposigory;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Faq Controller 진입 전");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		String path = request.getRequestURI();
		String kind = path.substring(path.lastIndexOf("faq"));
		System.out.println(kind);
		
		boolean adminCheck = false;
		String msg = "접근 권한이 없습니다.";
		
		if(memberVO != null && memberVO.getType() == 3) {
			// write
			if(kind.equals("faqWrite")) {
				adminCheck = true;
			} else {
			// update, delete
				int num = Integer.parseInt(request.getParameter("num"));
				FaqVO faqVO = new FaqVO();
				faqVO.setNum(num);
				faqVO = faqReposigory.findById(faqVO.getNum()).get();
				
				System.out.println("------------");
				System.out.println(memberVO.getId());
				System.out.println(faqVO.getWriter());
				System.out.println("------------");
				
				if( memberVO.getId().equals(faqVO.getWriter()) ) {
					adminCheck = true;
					msg = "작성자만 접근 가능합니다.";
				}
			}
		}
		
		if(!adminCheck) {
			System.out.println("관리자 로그인이 필요한 회원 or 로그인이 필요");
			request.setAttribute("msg", msg);
			request.setAttribute("path", "./faqList?page=0&searchType=전체&keyword=");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		//return HandlerInterceptor.super.preHandle(request, response, handler);
		return adminCheck;
	}
	
	public boolean loginAdminCheck(long type, String kind) {
	    return true;
	}
}
