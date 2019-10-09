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


public class AdminProductListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		List<Category> categoryList = null;
		try {
			categoryList = service.findCategoryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("categoryList", categoryList);

		try {
			productList = service.findProductAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
