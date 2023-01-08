package com.revs.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revs.microservices.limitsservice.config.AppPropertyConfig;
import com.revs.microservices.limitsservice.entity.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private AppPropertyConfig config;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}
	
}
