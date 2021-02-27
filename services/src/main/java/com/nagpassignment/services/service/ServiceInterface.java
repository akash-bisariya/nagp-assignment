package com.nagpassignment.services.service;

import java.util.List;

import com.nagpassignment.services.model.ServiceModel;


public interface ServiceInterface {

	ServiceModel addServices(String serviceName, String serviceDescription);

	List<ServiceModel> getAllServices();

	
}
	