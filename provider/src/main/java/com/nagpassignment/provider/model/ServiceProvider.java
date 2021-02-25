package com.nagpassignment.provider.model;

public class ServiceProvider {
	Long providerId;
	String name;
	String servicePinCode;
	String mobile;
	
	public ServiceProvider(Long providerId, String name, String servicePinCode, String mobile, String serviceCharges) {
		super();
		this.providerId = providerId;
		this.name = name;
		this.servicePinCode = servicePinCode;
		this.mobile = mobile;
		this.serviceCharges = serviceCharges;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServicePinCode() {
		return servicePinCode;
	}
	public void setServicePinCode(String servicePinCode) {
		this.servicePinCode = servicePinCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getServiceCharges() {
		return serviceCharges;
	}
	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	//perhour charge
	String serviceCharges;

}
