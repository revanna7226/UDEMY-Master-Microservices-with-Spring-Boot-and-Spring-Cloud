package com.revs.webservice.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"atmPin", "account_balance"})
@JsonFilter("Filter")
public class BankAccount {

	@JsonProperty("account_number")
	private long number;
	
	@JsonProperty("account_type")
	private String type;
	
	@JsonProperty("account_balance")
	private String balance;
	
	@JsonProperty("account_atm_pin")
	// static-filtering
	//@JsonIgnore
	private String atmPin;

	public BankAccount(long number, String type, String balance, String atmPin) {
		this.number = number;
		this.type = type;
		this.balance = balance;
		this.atmPin = atmPin;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(String atmPin) {
		this.atmPin = atmPin;
	}

	@Override
	public String toString() {
		return "BankAccount [number=" + number + ", type=" + type + ", balance=" + balance + ", atmPin=" + atmPin + "]";
	}
	
}
