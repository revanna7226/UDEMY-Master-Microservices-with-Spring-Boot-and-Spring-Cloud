package com.revs.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	
	@GetMapping("/sample-api")
	// @Retry(name = "sample-api", fallbackMethod = "getFallbackResponse")
	@CircuitBreaker(name = "sample-api", fallbackMethod = "getFallbackResponse")
	public String sampleApi() {
		logger.info("Sample api call received");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:6523", String.class);
		return responseEntity.getBody();
		
		// return "sample api";
	}
	
	public String getFallbackResponse(Exception ex) {
		return ex.getMessage();
	}
}
