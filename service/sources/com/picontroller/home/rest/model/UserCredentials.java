package com.picontroller.home.rest.model;

/** User credentials for JSON deserialization. */
class UserCredentials {
	String userName;
	String password;

	public UserCredentials(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public UserCredentials() {
		this.userName = "";
		this.password = "";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}