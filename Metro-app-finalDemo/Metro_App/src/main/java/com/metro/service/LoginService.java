package com.metro.service;

import com.metro.modal.User;

public interface LoginService {

	public User userLogin(String username, String password) throws ClassNotFoundException;
}
