package net.nsimpler.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonModelInterceptor extends HandlerInterceptorAdapter{
	
	
	public void postHandler(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndview) throws Exception{
		
		System.out.println("CommonModelInterceptor 실행 \n");
		
		modelAndview.addObject("project","nsimpler");
	}
}
