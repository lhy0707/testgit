package com.detu.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSourceUtils {
	//从连接池中获取Connection
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//创建ThreadLocal 
	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
	
	//开启事物
	public static void startTransaction() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.setAutoCommit(false);
	}
	
	
	//获得当前线程上绑定的conn
	public static Connection getCurrentConnection() throws SQLException {
		//从ThreadLocal寻找 当前线程是否有对应Connection
		Connection conn = t1.get();
		if(conn==null) {
			//获得新的Connection
			conn = getConnection();
			//将conn资源绑定到ThreadLocal上
			t1.set(conn);
		}
		return conn;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//回滚事物
	public static void rollback() throws SQLException {
		getCurrentConnection().rollback();
	}
	
	//回滚事物
	public static void commit() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.commit();
		//将Connection从ThreadLocal中移除
		t1.remove();
		conn.close();
	}
	
	
}
