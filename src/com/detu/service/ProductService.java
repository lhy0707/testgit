package com.detu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.detu.dao.ProductDao;
import com.detu.pojo.PageBean;
import com.detu.pojo.Product;

public class ProductService {
	public List<Product> findAllProduct() throws SQLException{
		
		ProductDao dao = new ProductDao();
		List<Product> productList = dao.findAllProduct();
		return productList;
		
	}

	public PageBean<Product> findPageBean(int currentPage, int currentCount) throws SQLException {
		//将数据封装到PageBean
		PageBean page = new PageBean();
		ProductDao dao = new ProductDao();
		//当前页 private int currentPage;
		page.setCurrentPage(currentPage);
		//当前页显示的条数 private int currentCount;
		page.setCurrentCount(currentCount);
		//总条数 private int totalCount;
		int totalCount = dao.getTotalCount();
		page.setTotalCount(totalCount);
		//总页数 private int totalPage;
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		page.setTotalPage(totalPage);
		//每页显示的数据 List<T> productList = new ArrayList<>();
		int index = (currentPage-1)*currentCount;
		List<Product> productList = dao.findProductListForPageBean(index,currentCount);
		page.setProductList(productList);
		return page;
	}

}
