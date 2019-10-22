package com.ems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 
 * 字符过滤器:
 * 
 * @author zhuo
 *
 */
@WebFilter("/*")
public class CharacteFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器....");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse respose, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
    	respose.setContentType("text/html; charset=utf-8"); 
    	chain.doFilter(request, respose);
    	respose.setCharacterEncoding("UTF-8");
		
	}


	@Override
	public void destroy() {
		
	}
}
