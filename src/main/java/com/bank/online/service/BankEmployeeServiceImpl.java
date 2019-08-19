package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.BankEmployee;
import com.bank.online.model.Customer;
import com.bank.online.repository.BankRepository;
import com.bank.online.repository.CustomerRepository;

@Service
public class BankEmployeeServiceImpl implements BankEmployeeService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	public BankEmployeeServiceImpl(CustomerRepository customerRepository,BankRepository bankRepository)
	{
		this.customerRepository=customerRepository;
		this.bankRepository=bankRepository;

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
	public Optional<Customer> findById(long customerId) {
		// TODO Auto-generated method stub
		System.out.println("Finding Id by Customer Id");
		return this.customerRepository.findById(customerId);
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Deleting customer based on Id");
		this.customerRepository.deleteById(customerId);
	}

	@Override
	public Optional<BankEmployee> findByEmployeeIdAndEmployeePassword(long id, String pwd) {
		// TODO Auto-generated method stub
		return 	this.bankRepository.findByEmployeeIdAndEmployeePassword(id, pwd);

	}
	
}
