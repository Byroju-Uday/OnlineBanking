package com.bank.online.service;

import java.util.ArrayList;
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
	@Transactional
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}
	
	@Override
	@Transactional
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<>();
    	this.customerRepository.findAll().forEach(customer -> list.add(customer));
    	return list;
	}
	
	@Override
	@Transactional
	public Customer findById(long customerId) {
		// TODO Auto-generated method stub
		return this.customerRepository.findById(customerId).get();
	}

	@Override
	@Transactional
	public void deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		
		this.customerRepository.deleteById(customerId);
		
	}

	@Override
	public Optional<Customer> listById(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	@Transactional
//	public void addTweetToId(long userId) {
//		User user = this.userRepository.findById(userId).get();
//		
//		
//	}
}
