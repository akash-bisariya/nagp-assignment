package com.nagpassignment.admin.service;

import java.util.List;

import com.nagpassignment.admin.model.ServiceModel;
import com.nagpassignment.admin.model.ServiceProvider;

public interface AdminService {
	
	List<ServiceProvider> bookService(String userId,String serviceId,String pinCode);
	
	List<Object> getAllSevices();
	
}
