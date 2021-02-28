package com.nagpassignment.admin.service;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagpassignment.admin.model.ServiceProvider;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private EurekaClient eurekaClient;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Override
	public List<ServiceProvider> bookService(String userId, String serviceId, String pinCode) {
		String url = "/getprovider/" + pinCode;
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("provider", false);
		ResponseEntity<ServiceProvider[]> provider = restTemplate.getForEntity(instance.getHomePageUrl()+ url, ServiceProvider[].class);
		List<ServiceProvider> providerList = (Arrays.asList(provider.getBody()));
		List<ServiceProvider> servingProviderList= new ArrayList<ServiceProvider>();
		for (ServiceProvider i : providerList) {
			String[] list = i.getServices();
			for(String str : list) {
				if(str.equals(serviceId)) {
					servingProviderList.add(i);
				}	
			}
				
		}
		
		return servingProviderList;	
	}

	@Override
	public List<Object> getAllSevices() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("services", false);
		Object[] list = restTemplate.getForObject(instance.getHomePageUrl()+"/getallservices", Object[].class);
		List<Object> serviceList = Arrays.asList(list);
		return serviceList;
	}

}
