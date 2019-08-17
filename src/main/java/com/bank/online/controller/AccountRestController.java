package com.bank.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.Account;
import com.bank.online.service.AccountService;

@RestController
@RequestMapping("/data")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/accounts")
    public List<Account> listAll(){
        System.out.println("Inside the list all method....");
        return this.accountService.listAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account findEmployeeById(@PathVariable("id") long id){
        return this.accountService.findById(id);
    }
    
    
}
