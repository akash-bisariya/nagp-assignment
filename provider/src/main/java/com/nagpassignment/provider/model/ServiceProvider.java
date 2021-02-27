package com.nagpassignment.provider.model;

public class ServiceProvider {
	Long providerId;
	String name;
	String servicePinCode;
	String mobile;
	//per hour charges
	String serviceCharges;
	private String[] services;
	
	
	public ServiceProvider(Long providerId, String name, String servicePinCode, String mobile, String serviceCharges,String[] services) {
		super();
		this.providerId = providerId;
		this.name = name;
		this.servicePinCode = servicePinCode;
		this.mobile = mobile;
		this.serviceCharges = serviceCharges;
		this.services = services;
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
	public String[] getServices() {
		return services;
	}
	public void setServices(String[] services) {
		this.services = services;
	}


}
