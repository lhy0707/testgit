package com.detu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.detu.util.DataSourceUtils;
import com.detu.util.MyDataSourceUtils;

public class TransferDao {

	public void out(String out, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		String sql = "update test set money=money-? where name=?";
		runner.update(conn,sql,money,out);
		
		
	}

	public void in(String in, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		String sql = "update test set money=money+? where name=?";
		runner.update(conn,sql,money,in);
		
	}

}
