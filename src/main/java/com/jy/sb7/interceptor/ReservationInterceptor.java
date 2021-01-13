package com.jy.sb7.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class ReservationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		
		boolean check = false;
		if(obj != null) { //로그인 된 상태
			check= true;
		}
		request.setAttribute("msg", "로그인이 필요합니다");
		request.setAttribute("path", "../member/memberLogin");
		RequestDispatcher view =request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		return check;
	}
		
		
}
