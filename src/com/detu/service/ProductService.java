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
		//�����ݷ�װ��PageBean
		PageBean page = new PageBean();
		ProductDao dao = new ProductDao();
		//��ǰҳ private int currentPage;
		page.setCurrentPage(currentPage);
		//��ǰҳ��ʾ������ private int currentCount;
		page.setCurrentCount(currentCount);
		//������ private int totalCount;
		int totalCount = dao.getTotalCount();
		page.setTotalCount(totalCount);
		//��ҳ�� private int totalPage;
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		page.setTotalPage(totalPage);
		//ÿҳ��ʾ������ List<T> productList = new ArrayList<>();
		int index = (currentPage-1)*currentCount;
		List<Product> productList = dao.findProductListForPageBean(index,currentCount);
		page.setProductList(productList);
		return page;
	}

}
