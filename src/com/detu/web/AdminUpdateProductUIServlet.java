package com.detu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detu.pojo.Category;
import com.detu.pojo.Product;
import com.detu.service.AdminProductService;


public class AdminUpdateProductUIServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid = request.getParameter("pid");
		AdminProductService service = new AdminProductService();
		Product product = null;
		List<Category> category =null;
		try {
			product = service.findProductByPid(pid);
			category = service.findCategoryAll();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("product", product);
		request.setAttribute("category", category);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
