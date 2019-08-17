package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import com.bank.online.model.Customer;

public interface BankEmployeeService {
	
	Customer saveCustomer(Customer customer);

    List<Customer> listAll();

    Optional<Customer> findById(long customerId);

    void deleteCustomer(long customerId);
}
