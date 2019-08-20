package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import com.bank.online.model.Account;
import com.bank.online.model.Customer;



public interface CustomerService {
	
	   Customer saveCustomer(Customer customer);

	   List<Customer> listAll();

	   Customer listById(long customerId);

	   void deleteCustomer(long customerId);
}
