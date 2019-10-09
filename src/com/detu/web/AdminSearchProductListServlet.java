package com.detu.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.detu.pojo.Category;
import com.detu.pojo.Condition;
import com.detu.pojo.Product;
import com.detu.service.AdminProductService;


public class AdminSearchProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		List<Category> categoryList = null;
		try {
			categoryList = service.findCategoryAll();
			productList =  service.findProductByCondition(condition);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("condition", condition);

		request.setAttribute("productList", productList);

		request.setAttribute("categoryList", categoryList);

		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
