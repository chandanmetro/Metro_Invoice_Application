package com.metro.modal;

import com.metro.service.ServerInfo;

public class User {

	private String name;

	private String password;

	private int storeNumber;

	private String serverURL;
	private String tpLocation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
		serverURL = ServerInfo.getServerName(storeNumber);
		tpLocation = ServerInfo.getTPFileLocation(storeNumber);
	}

	public String getServerURL() {
		return serverURL;
	}

	public String getTPFileLocation() {
		return tpLocation;
	}

	public User(String name, String password, int storeNumber) {
		super();
		this.name = name;
		this.password = password;
		this.storeNumber = storeNumber;

	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", storeNumber=" + storeNumber + "]";
	}

}
