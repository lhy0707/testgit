package com.detu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.detu.pojo.user;
import com.detu.service.UserService;


public class SignIn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		String checkImg = request.getParameter("checkImg");
//		String checkCode = (String) request.getSession().getAttribute("checkcode_session");
//		System.out.println(checkImg);
//		System.out.println(checkCode);
		UserService service = new UserService();
		user login = null;
		try {
			login = service.findUserByNamePwd(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(login!=null) {
			String autosign = request.getParameter("autosign");
			if(autosign!=null) {
				Cookie username_autosignin = new Cookie("username_autosignin",username);
				Cookie password_autosignin = new Cookie("password_autosignin",password);
				//设置一小时
				username_autosignin.setMaxAge(60*60);
				password_autosignin.setMaxAge(60*60);
				
				//设置cookie的携带路径
				username_autosignin.setPath(request.getContextPath());
				password_autosignin.setPath(request.getContextPath());
				
				response.addCookie(username_autosignin);
				response.addCookie(password_autosignin);
			}
			

			session.setAttribute("user", login);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
//			if(checkImg.equals(checkCode)) {
//			}else {
//				request.setAttribute("loginInfo", "验证错误");
//				request.getRequestDispatcher("/login.jsp").forward(request, response);
//				return;
//			}
//			
		}else {
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
