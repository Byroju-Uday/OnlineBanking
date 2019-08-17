package com.bank.online.service;


import java.util.List;

import com.bank.online.model.Transaction;

public interface TransactionService {


	public Transaction saveTransaction(Transaction transaction);
	
	List<Transaction> listAllTransactions();
	  
	

}
