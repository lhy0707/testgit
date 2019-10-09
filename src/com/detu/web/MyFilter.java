package com.detu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detu.pojo.user;
import com.detu.service.UserService;

public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String cookie_username = null;
		String cookie_password = null;
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			
			for (Cookie cookie : cookies) {
				if("username_autosignin".equals(cookie.getName())) {
					cookie_username = cookie.getValue();
					System.out.println(cookie_username);
				}
				if("password_autosignin".equals(cookie.getName())) {
					cookie_password = cookie.getValue();
					System.out.println(cookie_password);
				}
				
			}
			if(cookie_username!=null&&cookie_password!=null) {
				UserService service = new UserService();
				user login = null;
				try {
					login = service.findUserByNamePwd(cookie_username,cookie_password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				req.setAttribute("user", login);
				
			}
			chain.doFilter(req, resp);
		}
		
		
		
		
	}
	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
