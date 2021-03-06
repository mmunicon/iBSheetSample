package com.myapp.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class AccessInterceptor implements HandlerInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(AccessInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// TODO
		// Access Intercept
		/*
		if (request.getRequestURI().startsWith("/login")) {
			System.out.println("startWith intercept");
			return false;
		}
		*/
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {		
		log.debug(request.getRequestURI());
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}