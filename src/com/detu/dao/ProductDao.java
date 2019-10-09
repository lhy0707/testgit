package com.detu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.detu.pojo.Product;
import com.detu.util.DataSourceUtils;

public class ProductDao {
	 public List<Product> findAllProduct() throws SQLException{
		 QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		 String sql = "select * from product";
		 List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		 return productList;
	 }

	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		return query.intValue();
	}

	public List<Product> findProductListForPageBean(int index, int currentCount) throws SQLException {
		QueryRunner runner  = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		List<Product> list =  runner.query(sql, new BeanListHandler<Product>(Product.class), index,currentCount);
		
		return list;
		
	}

}
