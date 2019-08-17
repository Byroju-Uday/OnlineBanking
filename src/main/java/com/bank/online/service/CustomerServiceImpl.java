package com.bank.online.service;

import java.util.List;

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
		System.out.println("The Records"+customer);
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public List<Customer> listAll() {
		System.out.println("Listing all the records");
		return this.customerRepository.findAll();
	}

	@Override
	public Customer findById(long empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(long empId) {
		// TODO Auto-generated method stub
		
	}

}
