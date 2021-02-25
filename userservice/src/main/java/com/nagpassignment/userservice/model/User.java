package com.nagpassignment.userservice.model;

public class User {
	Long userId;
	String userName;
	String emailId;

	public User(Long userId, String userName, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
