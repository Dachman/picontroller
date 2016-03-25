package com.picontroller.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User entity.
 * 
 * @author dcharles
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userRole;

	public User(Integer userId, String userName, String userPassword, String userRole) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.setUserRole(userRole);
	}

	public User() {
		this.userId = 0;
		this.userName = "";
		this.userPassword = "";
		this.setUserRole("");
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId:" + userId + ", userName:" + userName + ", userRole:" + userRole + "]";
	}

}
