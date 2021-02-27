package com.nagpassignment.provider.service;

import java.util.List;
import java.util.Map;

import com.nagpassignment.provider.model.ServiceProvider;


public interface ServiceProviderService {

	ServiceProvider addServiceProvider(String name, String servicePincode, String mobile, String serviceCharges,String[] services);

	List<ServiceProvider> getAllServiceProvider();
	
	List<ServiceProvider> getProviderByPinCode(String pincode);
	
}
	