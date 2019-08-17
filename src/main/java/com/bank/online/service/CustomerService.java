package com.bank.online.service;

import java.util.Optional;

import com.bank.online.model.Customer;


public interface CustomerService {
	
	public Optional<Customer> listById(long customerId);

}
