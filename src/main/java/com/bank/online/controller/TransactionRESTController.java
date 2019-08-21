package com.bank.online.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.online.model.Account;
import com.bank.online.model.Transaction;
import com.bank.online.model.TransactionUtil;
import com.bank.online.service.AccountService;
import com.bank.online.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/")
public class TransactionRESTController {
	
	long minimum_balance = 5000;

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(value = "/transactionlist")
    public List<Transaction> listAll(){
        System.out.println("Inside the list all method....");
        return this.transactionService.listAllTransactions();
    }

	 @PostMapping(value = "/saveTransaction")
	 public boolean saveTransaction(@Valid @RequestBody TransactionUtil transactionUtil) throws ParseException{
		 boolean output = true;
		 String typeOfTransaction = transactionUtil.typeOfTransaction;
			long transactionAmount = transactionUtil.transactionAmount;
			long fromAccountId = transactionUtil.fromAccountId;
			long toAccountId = transactionUtil.toAccountId;
			
			Account fromAccount = accountService.findById(fromAccountId);
			Account toAccount = accountService.findById(toAccountId);
			long from_user_balance = fromAccount.getAccountBalance();
			long to_user_balance = toAccount.getAccountBalance();
			
			
			Transaction transactionFrom = new Transaction();
			Transaction transactionTo = new Transaction();
			
			if(transactionAmount <= from_user_balance && (from_user_balance-transactionAmount)>=minimum_balance)
			{	long millis=System.currentTimeMillis();  
			 //Timestamp stamp = new Timestamp(System.currentTimeMillis());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date date1= new Date();
				String date_string = format.format(date1);
				System.out.println("the date of the date_string is "+ date_string);
				Date date_final = format.parse(date_string);
				
				//java.util.Date date=new java.util.Date(millis); 
				transactionFrom.setUpdatedBalance(from_user_balance-transactionAmount);
				transactionFrom.setDate(date1);
				transactionFrom.setTimeStamp(millis);
				transactionFrom.setTypeOfTransaction(typeOfTransaction);
				transactionFrom.setTransactionAmount(transactionAmount);
				transactionFrom.setFromAccountId(fromAccountId);
				transactionFrom.setToAccountId(toAccountId);
				transactionFrom.setAccount(fromAccount);
				
				fromAccount.addTransaction(transactionFrom);
				fromAccount.setAccountBalance(transactionFrom.getUpdatedBalance());
				toAccount.setAccountBalance(toAccount.getAccountBalance()+transactionAmount);
				
				transactionTo.setUpdatedBalance(toAccount.getAccountBalance());
				transactionTo.setDate(date1);
				transactionTo.setTimeStamp(millis);
				transactionTo.setTypeOfTransaction("credit");
				transactionTo.setTransactionAmount(transactionAmount);
				transactionTo.setFromAccountId(fromAccountId);
				transactionTo.setToAccountId(toAccountId);
				transactionTo.setAccount(toAccount);
				toAccount.addTransaction(transactionTo);
				
				
				this.accountService.saveAccount(fromAccount);
				this.accountService.saveAccount(toAccount);
				System.out.println("Transaction has been created");
				
				output = true;
			}
			else
			{
				 output = false;
				System.out.println("Unsufficient balance");
			
			}
			return output;
	 }
	 
	 @GetMapping("/transaction/{id}")
		public Set<Transaction> findUserById(@PathVariable("id") long id)
		{
		 
		 	Set<Transaction> transactionSet = (Set<Transaction>) accountService.findById(id).getTransactionSet();
		 	
			return transactionSet;
		}
	 
	 
}
