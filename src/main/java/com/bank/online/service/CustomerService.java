package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import com.bank.online.model.Customer;



public interface CustomerService {
	
	public Optional<Customer> listById(long customerId);
	
	Customer saveCustomer(Customer customer);

	   List<Customer> listAll();

	   Customer findById(long customerId);

	   void deleteCustomer(long customerId);
	   
	   //void addTweetToId(long userId);

}
