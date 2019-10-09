package com.detu.study;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		String lastTime = format.format(date);
		
		Cookie cookie = new Cookie("lastTime",lastTime);
		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);
		
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie1:cookies) {
				if(cookie1.getName().equals("lastTime")) {
					lastAccessTime = cookie1.getValue();
				}
			}

		}
		response.setContentType("text/html;charset=utf-8");
		if(cookie == null) {
			response.getWriter().print("你是第一次登陆网站!");
		}else {
			response.getWriter().print("上次登陆时间为:"+lastAccessTime);
		}
		
	}
}
