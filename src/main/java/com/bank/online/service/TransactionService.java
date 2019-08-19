package com.bank.online.service;


import java.util.List;

import com.bank.online.model.Account;
import com.bank.online.model.Transaction;

public interface TransactionService {


	   List<Transaction> listAllTransactions();

	   Transaction findById(long transactionId);

	   void deleteTransaction(long transactionId);

	public Transaction saveTransaction(Transaction transaction);
	  
	

}
