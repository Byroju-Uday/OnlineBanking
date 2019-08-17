package com.bank.online.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.Customer;
import com.bank.online.service.CustomerService;

@RestController
@RequestMapping("/api/v1/")
public class CustomerRestController {
	 @Autowired
	private CustomerService customerService;
	 
	 @GetMapping(value = "/customers")
	    public List<Customer> listAll(){
	        System.out.println("Inside the list all method....");
	        return this.customerService.listAll();
	    }
	 
	 @PostMapping(value="/customers")
	    public void saveEmployee(@Valid @RequestBody Customer customer){
		 this.customerService.saveCustomer(customer);
	    }
}
