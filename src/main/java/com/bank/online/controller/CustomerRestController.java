package com.bank.online.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.Customer;
import com.bank.online.model.CustomerCredentials;
import com.bank.online.model.CustomerValidation;
import com.bank.online.service.CustomerService;


@CrossOrigin
@RestController 
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/profile/{id}") //produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Customer listById(@PathVariable("id") long id)
	{
		return this.customerService.findById(id);
	}
	
	@PostMapping(value="/customerLoginValidation")
	public boolean customerLoginValidaiton(@Valid @RequestBody CustomerCredentials customerCredentials) {
		
		System.out.println("came inside the customerLoginValidation function of CustomerRestController");
		Customer customer = customerService.findById(customerCredentials.customerId);
		if(customer!=null)
		{	
			System.out.println("Customer is found with that ID");
			if(customer.getPassword().equals(customerCredentials.password))
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	@PostMapping(value="/checking")
	public void checking(@Valid @RequestBody CustomerCredentials customerCredentials)
	{
		System.out.println("came inside the checking function");
	}
}
