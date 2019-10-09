package com.detu.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSourceUtils {
	//�����ӳ��л�ȡConnection
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//����ThreadLocal 
	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
	
	//��������
	public static void startTransaction() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.setAutoCommit(false);
	}
	
	
	//��õ�ǰ�߳��ϰ󶨵�conn
	public static Connection getCurrentConnection() throws SQLException {
		//��ThreadLocalѰ�� ��ǰ�߳��Ƿ��ж�ӦConnection
		Connection conn = t1.get();
		if(conn==null) {
			//����µ�Connection
			conn = getConnection();
			//��conn��Դ�󶨵�ThreadLocal��
			t1.set(conn);
		}
		return conn;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//�ع�����
	public static void rollback() throws SQLException {
		getCurrentConnection().rollback();
	}
	
	//�ع�����
	public static void commit() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.commit();
		//��Connection��ThreadLocal���Ƴ�
		t1.remove();
		conn.close();
	}
	
	
}
