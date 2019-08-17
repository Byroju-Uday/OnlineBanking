package com.bank.online.service;

import java.util.List;

import com.bank.online.model.Customer;

public interface BankEmployeeService {
	
	Customer saveCustomer(Customer customer);

    List<Customer> listAll();

    Customer findById(long customerId);

    void deleteCustomer(long customerId);
}
