package com.metro.service;

import com.metro.dao.UserLoginDao;
import com.metro.dao.UserLoginDaoImpl;
import com.metro.modal.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public User userLogin(String username, String password) throws ClassNotFoundException {
		UserLoginDao userLoginDao = new UserLoginDaoImpl();
		return userLoginDao.userLogin(username, password);
	}

}
