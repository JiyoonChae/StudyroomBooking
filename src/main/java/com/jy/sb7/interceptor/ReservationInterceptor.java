package com.jy.sb7.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jy.sb7.member.MemberVO;
@Component
public class ReservationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberVO obj = (MemberVO)session.getAttribute("member");
		
		System.out.println("preHandle 진입");
		boolean check = false;
		if(obj != null) { //로그인 된 상태
			System.out.println("로그인된 회원");
			check= true;
		}
		
		if(!check) {
			System.out.println("로그인 안 된 회원");
			request.setAttribute("msg", "로그인이 필요합니다");
			request.setAttribute("path", "../member/memberLogin");
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
		
		
}
