package com.detu.study;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.detu.pojo.user;
import com.detu.util.DataSourceUtils;

public class LoginServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String checkImg = request.getParameter("checkImg");
		String checkCode = (String) request.getSession().getAttribute("checkcode_session");
		if(!checkImg.equals(checkCode)) {
			request.setAttribute("loginInfo", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
			
		}
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user login = null;
		
		try {
			login = login(username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(login != null) {
			request.getSession().setAttribute("user", login);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}else {
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	
	}
	
	public user login(String username,String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		user user = runner.query(sql,new BeanHandler<user>(user.class),username,password);
		return user;
		
	}
}
