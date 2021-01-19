package com.jy.sb7.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jy.sb7.member.MemberVO;
import com.jy.sb7.res.ReservationController;
import com.jy.sb7.res.ReservationVO;
@Component
public class ResConfirmInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러 갔다가 나오는 것. revNum , id가 일치해야함.
		System.out.println("post 핸들러 진입");
		HttpSession session = request.getSession();
		MemberVO obj = (MemberVO)session.getAttribute("member");
		String id = obj.getId();
		System.out.println("id : " + id);
		
		//revNum 꺼내기 - key를 알고있어야함. ("resInfo", resVO)
		Map<String, Object> model = modelAndView.getModel();
		ReservationVO resVO = (ReservationVO)model.get("resInfo");
		String user =  resVO.getId();
		long revNum = resVO.getRevNum();
		System.out.println("컨트롤러 후 id + "+user);
		System.out.println("예약번호 : "+revNum);
		if(!id.equals(user)) {
			modelAndView.addObject("msg", "예약자가 아닙니다");
			modelAndView.addObject("path", "../");
			modelAndView.setViewName("common/result");
		}
		
		/*
		 * Object resVO = modelMap.get(();
		 * 
		 * if(resVO.getId().equals(obj))
		 */
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	
		
		
}
