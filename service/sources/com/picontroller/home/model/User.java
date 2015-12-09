package com.picontroller.home.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * User entity.
 * @author dcharles
 *
 */
@Table
public class User {

	@PrimaryKey
	private Integer userId;
	@Column
	private String userName;
	@Column
	private String userPassword;
	@Column
	private String userRole;
	
	
	public User(Integer userId, String userName, String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.setUserRole(userRole);
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
	public String toString(){
		return "User [userId:"+userId+", userName:"+userName+", userRole:"+userRole+"]";
	}
	
}
