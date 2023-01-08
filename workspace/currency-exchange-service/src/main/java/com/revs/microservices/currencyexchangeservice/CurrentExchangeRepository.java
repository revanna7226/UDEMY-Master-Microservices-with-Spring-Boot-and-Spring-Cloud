package com.revs.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);
	
}
