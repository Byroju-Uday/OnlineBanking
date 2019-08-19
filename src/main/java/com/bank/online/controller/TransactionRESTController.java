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

import com.bank.online.model.Transaction;
import com.bank.online.service.TransactionService;


@RestController
@RequestMapping(value = "/api/v1/")
public class TransactionRESTController {

	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping(value = "/transactionlist")
    public List<Transaction> listAll(){
        System.out.println("Inside the list all method....");
        return this.transactionService.listAllTransactions();
    }

	 @PostMapping(value = "/transaction")
	 public void saveCustomers(@Valid @RequestBody Transaction transaction){
		 
		 this.transactionService.saveTransaction(transaction);
	 }
	 
	 
}
