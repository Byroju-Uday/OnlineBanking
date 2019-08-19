package com.bank.online.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.BankEmployee;
import com.bank.online.model.Customer;
import com.bank.online.service.BankEmployeeService;

@RestController
@RequestMapping("/employee")
public class BankEmployeeRestController {

	@Autowired
	private BankEmployeeService bankEmployeeService;
	
	@GetMapping("/")
	public String bankLandingPage()
	{
		System.out.println("Came inside bankLandingPage function");
		bankEmployeeService.saveBankEmployee(new BankEmployee());
		return "onlineBankLanding";
	}
	 
	 @GetMapping(value = "/addCustomers")
	    public List<Customer> listAll(){
	        System.out.println("Inside the list all method....");
	        return this.bankEmployeeService.listAll();
	    }
	 
	 @PostMapping(value = "/addCustomers")
	    public void saveCustomers(@Valid @RequestBody Customer customer){
		 this.bankEmployeeService.saveCustomer(customer);
	    }
	 
	 @PostMapping(value = "/deleteCustomers")
	 	public void deleteCustomers(@Valid @RequestBody long customerId) {
		 this.bankEmployeeService.deleteCustomer(customerId);
	 }

}
