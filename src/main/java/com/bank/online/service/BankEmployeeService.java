package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import com.bank.online.model.BankEmployee;
import com.bank.online.model.Customer;

public interface BankEmployeeService {
	
	public BankEmployee saveBankEmployee(BankEmployee bankEmployee);
	
	Customer saveCustomer(Customer customer);

    List<Customer> listAll();

    Customer findById(long customerId);

    void deleteCustomer(long customerId);
    
	//Optional<BankEmployee> findByEmployeeIdAndEmployeePassword(long id,String pwd);
    Customer updateCustomer(long customerId, Customer customer);
}
