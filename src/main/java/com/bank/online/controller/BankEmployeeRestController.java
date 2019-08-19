package com.bank.online.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.BankEmployee;
import com.bank.online.model.Customer;
import com.bank.online.service.BankEmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class BankEmployeeRestController {

	@Autowired
	private BankEmployeeService employeeService;
	 
	 @GetMapping(value = "/addCustomers")
	    public List<Customer> listAll(){
	        System.out.println("Inside the list all method....");
	        return this.employeeService.listAll();
	    }
	 
	 @GetMapping(value = "/bankerlogin/{id}/{pwd}")
	    public Optional<BankEmployee> bankerLogin(@PathVariable("id") long id,@PathVariable("pwd") String pwd){
	        System.out.println("Inside the list all method....");
	        return this.employeeService.findByEmployeeIdAndEmployeePassword(id, pwd);
	    }
	 
	 @PostMapping(value = "/addCustomers")
	    public void saveCustomers(@Valid @RequestBody Customer customer){
		 this.employeeService.saveCustomer(customer);
	    }
	 
	 @PostMapping(value = "/deleteCustomers")
	 	public void deleteCustomers(@Valid @RequestBody long customerId) {
		 this.employeeService.deleteCustomer(customerId);
	 }

}
