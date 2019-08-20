package com.bank.online.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.Account;
import com.bank.online.model.Customer;
import com.bank.online.service.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/accounts")
    public List<Account> listAll(){
        System.out.println("Inside the list all method....");
        return this.accountService.listAll();
    }

    @GetMapping("/accounts/{id}")
    public Account findEmployeeById(@PathVariable("id") long id){
        return this.accountService.findById(id);
    }
    
    @PostMapping(value = "/accounts")
    public void saveAccount(@Valid @RequestBody Account account){
	 this.accountService.saveAccount(account);
    }
    
}
