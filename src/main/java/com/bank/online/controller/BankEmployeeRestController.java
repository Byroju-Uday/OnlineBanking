package com.bank.online.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityResult;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.BankEmployee;
import com.bank.online.model.Customer;
import com.bank.online.service.BankEmployeeService;

@RestController
@CrossOrigin
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
	 @GetMapping(value = "/getAllCustomers")
	    public List<Customer> listAll(){
	        System.out.println("Inside the list all method....");
	        return this.bankEmployeeService.listAll();
	    }
	 
//	 @GetMapping(value = "/bankerlogin/{id}/{pwd}")
//	    public Optional<BankEmployee> bankerLogin(@PathVariable("id") long id,@PathVariable("pwd") String pwd){
//	        System.out.println("Inside the list all method....");
//	        return this.employeeService.findByEmployeeIdAndEmployeePassword(id, pwd);
//	    }
	 
	 @PostMapping(value = "/")
	    public Customer saveCustomers(@Valid @RequestBody Customer customer){
		 String encodedString = Base64.getEncoder().encodeToString(customer.getPassword().getBytes());
		 byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		 String decodedString = new String(decodedBytes);
		 
		 //System.out.println("This is the encoded string "+encodedString);
		 //System.out.println("This is the decoded string "+decodedString);
		 customer.setPassword(encodedString);
		 return this.bankEmployeeService.saveCustomer(customer);
	    }
	 
	 
	  @PutMapping(value = "profile/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
		public Customer updateCustomer(@PathVariable("id") long customerId, @Valid @RequestBody Customer customer)
		{
			System.out.println("Inside Put method of UpdateCustomer");
			return this.bankEmployeeService.updateCustomer(customerId, customer);
		}
	 
	  @GetMapping(value = "/delete/{id}")
	 	public void deleteCustomers(@PathVariable long id) {
		 this.bankEmployeeService.deleteCustomer(id);
	 }

}
