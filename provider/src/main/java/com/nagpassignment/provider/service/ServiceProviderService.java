package com.nagpassignment.provider.service;

import java.util.List;
import java.util.Map;

import com.nagpassignment.provider.model.ServiceProvider;


public interface ServiceProviderService {

	ServiceProvider addServiceProvider(ServiceProvider serviceProvider);

	List<ServiceProvider> getAllServiceProvider();
	
	List<ServiceProvider> getProviderByPinCode(String pincode);
	
}
	