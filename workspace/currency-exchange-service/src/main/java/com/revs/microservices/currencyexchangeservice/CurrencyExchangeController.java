package com.revs.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrentExchangeRepository repo;
	
	@Autowired
	private Environment env;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to
			) {
		
//		CurrencyExchange currencyExchange = new CurrencyExchange(
//				1, 
//				from, 
//				to, 
//				BigDecimal.valueOf(65),
//				env.getProperty("local.server.port"));
		
		logger.info("retrieveExchangeValue with {} and {}", from, to);
		
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(env.getProperty("local.server.port"));
		
		return currencyExchange;
	}
	
	
}
