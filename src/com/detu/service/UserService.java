package com.detu.service;

import java.sql.SQLException;

import com.detu.dao.UserDao;
import com.detu.pojo.user;

public class UserService {

	public boolean checkUsernaem(String username) throws SQLException {
		UserDao dao = new UserDao();
		int i = dao.checkUsernaem(username);
		return i>0?true:false;
	}

	public user findUserByNamePwd(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		user login = dao.findUserByNamePwd(username,password);
		return login;
	}

}
