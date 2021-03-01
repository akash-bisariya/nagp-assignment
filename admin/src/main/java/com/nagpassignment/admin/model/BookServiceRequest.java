package com.nagpassignment.admin.model;

public class BookServiceRequest {
	String serviceId;
	String userId;
	String pinCode;
	
	public BookServiceRequest(String serviceId, String userId, String pinCode) {
		super();
		this.serviceId = serviceId;
		this.userId = userId;
		this.pinCode = pinCode;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
