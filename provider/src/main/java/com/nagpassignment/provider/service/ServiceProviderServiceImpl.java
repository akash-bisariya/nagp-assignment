package com.nagpassignment.provider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nagpassignment.provider.model.ServiceProvider;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	List<ServiceProvider> serviceProviders = new ArrayList<ServiceProvider>();
	private final AtomicLong counter = new AtomicLong(1000);

	@Override
	public ServiceProvider addServiceProvider(String name, String servicePincode, String mobile,
			String serviceCharges,String[] services) {
		ServiceProvider provider = new ServiceProvider(counter.incrementAndGet(), name, servicePincode, mobile,
				serviceCharges,services);
		this.serviceProviders.add(provider);
		return provider;
	}

	@Override
	public List<ServiceProvider> getAllServiceProvider() {
		return this.serviceProviders;
	}

	@Override
	public List<ServiceProvider> getProviderByPinCode(String pincode) {
		List<ServiceProvider> listOfProviders = new ArrayList<ServiceProvider>();
		for (ServiceProvider i : this.serviceProviders) {
			if (i.getServicePinCode().equals(pincode))
				listOfProviders.add(i);
		}
		return listOfProviders;
	}

}
