package com.nagpassignment.provider.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nagpassignment.provider.model.ServiceProvider;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
	
	private Map<String, ServiceProvider> serviceProviders = new ConcurrentHashMap<String, ServiceProvider>();
	private final AtomicLong counter = new AtomicLong(1000);

	@Override
	public ServiceProvider addServiceProvider(String name, String servicePincode, String mobile,
			String serviceCharges) {
		ServiceProvider provider = new ServiceProvider(counter.incrementAndGet(), name, servicePincode,mobile,serviceCharges);
		this.serviceProviders.put(provider.getProviderId().toString(), provider);
		return provider;
	}

	@Override
	public Map<String, ServiceProvider> getAllServiceProvider() {
		return this.serviceProviders;
	}

}
