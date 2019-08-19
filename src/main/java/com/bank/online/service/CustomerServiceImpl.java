package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Customer;
import com.bank.online.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		this.customerRepository=customerRepository;
	}
	
	@Override
	public Optional<Customer> listById(long customerId) {
		// TODO Auto-generated method stub
		System.out.println("Finding Id by Customer Id");
		return this.customerRepository.findById(customerId);
	}
}
