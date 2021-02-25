package com.nagpassignment.provider.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagpassignment.provider.model.ServiceProvider;
import com.nagpassignment.provider.service.ServiceProviderService;

@RestController
public class ServiceProviderController {

	@Autowired
	ServiceProviderService providerservice;

	@GetMapping("/addserviceprovider")
	ServiceProvider addProvider(@RequestParam(value = "name") String name,
			@RequestParam(value = "servicePinCode") String servicePincode,
			@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "serviceCharges") String serviceCharges) {
		return providerservice.addServiceProvider(name, servicePincode, mobile, serviceCharges);
	}

	@GetMapping("/getallproviders")
	Map<String, ServiceProvider> getAllProviders() {
		return providerservice.getAllServiceProvider();

	}

}
