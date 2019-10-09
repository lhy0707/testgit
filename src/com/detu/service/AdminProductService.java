package com.detu.service;

import java.sql.SQLException;
import java.util.List;

import com.detu.dao.AdminProductDao;
import com.detu.pojo.Category;
import com.detu.pojo.Condition;
import com.detu.pojo.Product;

public class AdminProductService {

	public List<Product> findProductAll() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductAll();
	}

	public List<Category> findCategoryAll() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		
		return dao.findCategoryAll();
	}

	public void addProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.addProduct(product);
		
	}

	public void delProduct(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.delProduct(pid);
		
	}

	public void delMoreProduct(String[] parameterValues) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.delMoreProduct(parameterValues);
		
	}

	public Product findProductByPid(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductByPid(pid);
		
	}

	public void updateProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.updateProduct(product);
		
	}

	public List<Product> findProductByCondition(Condition condition) throws SQLException {
		AdminProductDao dao = new AdminProductDao();		
		return dao.findProductByCondition(condition);
	}


}
