package com.detu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detu.service.SearchProductService;
import com.google.gson.Gson;

import net.sf.json.JSONArray;


public class SearchWordServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		SearchProductService service = new SearchProductService();
		List<Object> productList = null;
		try {
			productList = service.findProductByWord(word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//使用json的转换工具将对象或集合转成json格式的字符串
//		JSONArray fromObject = JSONArray.fromObject(productList);
//		fromObject.toString();
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
