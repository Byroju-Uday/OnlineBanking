package com.bank.online.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.online.model.Transaction;
import com.bank.online.service.TransactionService;


@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/")
	public String transaction(Model model) {
		
		System.out.println("Came inside the transaction");
		System.out.println("Calling new transaction from get");
		model.addAttribute("transaction", new Transaction());
		System.out.println(model);
		return "transaction";
	}
	
	@PostMapping(value = "/transaction")
	public String transactionDetails(
			@RequestParam("transactiontype")String typeoftransaction,
			@RequestParam("transactionamount")long transactionamount,
			@RequestParam("availableamount")long availablebalance,
			@RequestParam("tocustomerid")long tocustomerid,
			@RequestParam("fromcustomerid")long fromcustomerid,
			@RequestParam("transactionstatus")String status,
			@Valid @ModelAttribute("transaction")Transaction transaction,
			BindingResult bindingResult,HttpServletRequest req
				)throws IOException {
		if(bindingResult.hasErrors()){
            System.out.println("Error "+bindingResult.toString());
            return "transactionerror";
		}
		System.out.println("Inside Transaction");
		transaction.setTypeOfTransaction(typeoftransaction);
		transaction.setUpdatedBalance(availablebalance);
		transaction.setFromAccountId(fromcustomerid);
		transaction.setToAccountId(tocustomerid);
		transaction.setStatus(status);
		transaction.setTransactionAmount(transactionamount);
		long millis=System.currentTimeMillis();  
		java.util.Date date=new java.util.Date(millis); 
		java.sql.Date date_sql = new java.sql.Date(System.currentTimeMillis());
	    transaction.setDate(date_sql.toString());
		System.out.println(transaction);
		this.transactionService.saveTransaction(transaction);
		System.out.println("Records Saved Succesfully");
		return "transactionlist";
		
		
	}
	
	@GetMapping(value = "/transactionlist")
	public String transactionsList(Model model) {
		
        List<Transaction> transactions = this.transactionService.listAllTransactions();
        model.addAttribute("transactions", transactions);
		
		return "success";
	}
	
	@ExceptionHandler(IOException.class)
    public String handleException(HttpServletRequest request, Exception ex){
        return "transactionerror";
    }
}
