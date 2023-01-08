package com.revs.webservice.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.revs.webservice.entity.BankAccount;

@RestController
public class BankAccountResource {

	@GetMapping("/bank-accounts")
	public MappingJacksonValue getAll() {
		
		List<BankAccount> bankAccountsList = new ArrayList<>();
		bankAccountsList.add(new BankAccount(1234567890l, "Savings", "13,000/-", "1234"));
		bankAccountsList.add(new BankAccount(123456780l, "RD", "1,00,000/-", "4568"));
		bankAccountsList.add(new BankAccount(987654321l, "CU", "8,000/-", "8520"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bankAccountsList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("account_number");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("Filter", filter);
		mappingJacksonValue.setFilters(filterProvider);
		
		
		return mappingJacksonValue;
	}
	
//	@GetMapping("/bank-accounts/{id}")
//	public BankAccount getAccount() {
//		return new BankAccount(12345657890l, "SB", "200/-", "7894");
//	}
	
	// dynamic filtering
	@GetMapping("/bank-accounts/{id}")
	public MappingJacksonValue getAccount() {
		BankAccount ba = new BankAccount(12345657890l, "SB", "200/-", "7894");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(ba);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("account_number", "account_type");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("Filter", filter);
		mappingJacksonValue.setFilters(filterProvider);
		
		return mappingJacksonValue;
	}
	
}
