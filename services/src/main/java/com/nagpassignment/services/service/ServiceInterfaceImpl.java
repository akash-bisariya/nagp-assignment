package com.nagpassignment.services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nagpassignment.services.model.ServiceModel;

@Service
public class ServiceInterfaceImpl implements ServiceInterface {

	List<ServiceModel> services = new ArrayList<ServiceModel>();
	private final AtomicLong counter = new AtomicLong(2000);

	@Override
	public List<ServiceModel> getAllServices() {
		if (this.services.isEmpty()) {
			this.services.add(new ServiceModel(counter.incrementAndGet(), "Carpenter", "For all types of wood work"));
			this.services
					.add(new ServiceModel(counter.incrementAndGet(), "Electrician", "All types of electrical work"));
			this.services.add(new ServiceModel(counter.incrementAndGet(), "Salon", "Haircut for men and women"));
			this.services.add(new ServiceModel(counter.incrementAndGet(), "Cleaning", "House cleaning"));
			this.services.add(new ServiceModel(counter.incrementAndGet(), "AC Repair", "AC repair and service"));
			this.services.add(new ServiceModel(counter.incrementAndGet(), "Massage for men", "All types of massages"));
		}
		return this.services;
	}

	@Override
	public ServiceModel addServices(ServiceModel service) {
		ServiceModel servicemodel = new ServiceModel(counter.incrementAndGet(), service.getServiceName(), service.getServiceDescription());
		this.services.add(servicemodel);
		return servicemodel;
	}

}
