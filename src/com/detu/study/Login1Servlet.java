package com.detu.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login1Servlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String line = (String) request.getSession().getAttribute("checkcode_session");
		System.out.println(line);
		String name = "lhy";
		String username = request.getParameter("username");
		String check = request.getParameter("check");
		if(username.equals(name)) {
			if(line.equals(check)) {
				response.getWriter().print("success");
				return;
			}
		}
		response.getWriter().print("fail");
		
		
		
		
	}
}
