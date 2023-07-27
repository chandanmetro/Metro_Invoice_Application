package com.metro.dao;

import com.metro.modal.User;

public interface UserLoginDao {

	public User userLogin(String username, String password) throws ClassNotFoundException;

	public void invoiceDetails(String invoicenumber, String customerid, int storenumber, String date ) throws ClassNotFoundException;
}
