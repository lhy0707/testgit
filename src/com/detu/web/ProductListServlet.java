package com.detu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detu.pojo.PageBean;
import com.detu.pojo.Product;
import com.detu.service.ProductService;


public class ProductListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ProductService service = new ProductService();
		//模拟当前页为1
//		int currentPage = 1;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		//设置每页显示12条数据
		int currentCount = 12;
		
		PageBean<Product> pageBean = null;
		try {
			pageBean = service.findPageBean(currentPage, currentCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

}
