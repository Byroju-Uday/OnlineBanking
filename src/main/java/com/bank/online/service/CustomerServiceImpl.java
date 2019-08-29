package com.bank.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Account;
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
	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	@Transactional
	public List<Customer> listAll() {
		List<Customer> list = new ArrayList<>();
    	this.customerRepository.findAll().forEach(customer -> list.add(customer));
    	return list;
	}
	
	@Override
	@Transactional
	public Customer listById(long customerId) {
		return this.customerRepository.findById(customerId).get();
	}

	@Override
	@Transactional
	public void deleteCustomer(long customerId) {
		this.customerRepository.deleteById(customerId);
	}

	@Override
	public Set<Account> listAccounts(long customerId) {
		Customer customer = listById(customerId);		
		return customer.getBankAccountSet();
	}
}
