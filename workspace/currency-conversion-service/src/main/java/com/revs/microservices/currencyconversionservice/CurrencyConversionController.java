package com.revs.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) throws RestClientException {
		
		HashMap<String, String> uriPathvariables = new HashMap<>();
		
		uriPathvariables.put("from", from);
		uriPathvariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = null;
		try {
			responseEntity = restTemplate.getForEntity(
					"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
					CurrencyConversion.class, uriPathvariables);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 CurrencyConversion currencyConversion = responseEntity.getBody();
		 currencyConversion.setQuantity(quantity);
		 currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		 currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " RestTemplate");
		
		return currencyConversion;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) throws RestClientException {
		
		 CurrencyConversion currencyConversion = proxy.calculateCurrencyConversion(from, to);
		 currencyConversion.setQuantity(quantity);
		 currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		 currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " FeignClient");
		
		return currencyConversion;
	}
	
}
