package com.bank.online.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Customer;
import com.bank.online.repository.CustomerRepository;

@Service
public class BankEmployeeServiceImpl implements BankEmployeeService{

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    public BankEmployeeServiceImpl(CustomerRepository customerRepository){
	        this.customerRepository = customerRepository;
	    }

	    @Override
	    @Transactional
	    public Customer saveCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @Override
	    @Transactional
	    public List<Customer> listAll() {
	        return this.customerRepository.findAll();
	    }

	    @Override
	    @Transactional
	    public Customer findById(long customerId)  {
	        return this.customerRepository.findById(customerId).get();
	    }

	    @Override
	    @Transactional
	    public void deleteCustomer(long customerId) {
	        this.customerRepository.delete(this.customerRepository.findById(customerId).get());
	    }
	}
