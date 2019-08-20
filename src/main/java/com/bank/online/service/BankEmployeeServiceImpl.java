package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.BankEmployee;
import com.bank.online.model.Customer;
import com.bank.online.repository.BankEmployeeRepository;
import com.bank.online.repository.CustomerRepository;

@Service
public class BankEmployeeServiceImpl implements BankEmployeeService{
    
    @Autowired
    private BankEmployeeRepository bankEmployeeRepository; 

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    public BankEmployeeServiceImpl(CustomerRepository customerRepository, BankEmployeeRepository bankEmployeeRepository)
    {
        this.customerRepository = customerRepository;
        this.bankEmployeeRepository = bankEmployeeRepository;
    }
    
    @Override
    @Transactional
    public BankEmployee saveBankEmployee(BankEmployee bankEmployee) {
        System.out.println("The Records"+bankEmployee);
        return bankEmployeeRepository.save(bankEmployee);
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
    @Transactional
    public Customer findById(long customerId) {
        // TODO Auto-generated method stub
        System.out.println("Finding Id by Customer Id");
        return this.customerRepository.findById(customerId).get();
    }

    @Override
    @Transactional
    public void deleteCustomer(long customerId) {
        System.out.println("Deleting customer based on Id");
        this.customerRepository.deleteById(customerId);;
    }
}