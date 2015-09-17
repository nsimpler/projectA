package net.nsimpler.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession(false);
		
		System.out.println("AuthInterceptor 실행 \n");
		/*
		if(session==null){
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		
		if(session.getAttribute("auth")==null){
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		*/
		return true;
		
	}
}