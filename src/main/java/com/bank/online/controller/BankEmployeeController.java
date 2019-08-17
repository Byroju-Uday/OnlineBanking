package com.bank.online.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.Customer;
import com.bank.online.service.BankEmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class BankEmployeeController {

	@Autowired
	private BankEmployeeService employeeService;

	    @GetMapping(value = "/employees")
	    public List<Customer> listAll(){
	        System.out.println("Inside the list all method....");
	        return this.employeeService.listAll();
	    }

	    @GetMapping("/employees/{id}")
	    public Customer findEmployeeById(@PathVariable("id") long id){
	        return this.employeeService.findById(id);
	    }

	    @PostMapping("/employees")
	    public void saveEmployee(@Valid @RequestBody Customer customer){
	        this.employeeService.saveCustomer(customer);
	    }
	}
