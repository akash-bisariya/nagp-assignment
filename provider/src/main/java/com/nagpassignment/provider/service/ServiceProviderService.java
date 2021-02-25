package com.nagpassignment.provider.service;

import java.util.Map;

import com.nagpassignment.provider.model.ServiceProvider;


public interface ServiceProviderService {

	ServiceProvider addServiceProvider(String name, String servicePincode, String mobile, String serviceCharges);

	Map<String, ServiceProvider> getAllServiceProvider();
	
}
