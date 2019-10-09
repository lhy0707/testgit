package com.detu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.detu.pojo.user;
import com.detu.util.DataSourceUtils;

public class UserDao {

	public int checkUsernaem(String username) throws SQLException {
		QueryRunner runner  = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(username) from user where username=?";
		Long count = (Long) runner.query(sql, new ScalarHandler(),username);
		return count.intValue();
	}

	public user findUserByNamePwd(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		user user = runner.query(sql, new BeanHandler<user>(user.class),username,password);
		return user;
	}

}
