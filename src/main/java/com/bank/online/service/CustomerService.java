package com.bank.online.service;

import java.util.List;

import com.bank.online.model.Customer;


public interface CustomerService {
	Customer saveCustomer(Customer customer);

    List<Customer> listAll();

    Customer findById(long empId);

    void deleteCustomer(long empId);
}
