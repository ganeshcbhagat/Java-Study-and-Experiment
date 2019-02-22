package com.atmosphere.gotcha.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
@Lazy
public class RequestHandleInterceptorAdapter extends HandlerInterceptorAdapter {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		 LOG.info("------------------------------------------------------------------------------------------");
		 LOG.info("Request URL::" + request.getRequestURL().toString());
	  return true;
	 }

	 @Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
	  LOG.info("Request URL::" + request.getRequestURL().toString()+" is completed.");
	  LOG.info("------------------------------------------------------------------------------------------");
	 }
	 
}
