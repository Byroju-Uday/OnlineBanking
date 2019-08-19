package com.bank.online.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Transaction;
import com.bank.online.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	 public TransactionServiceImpl(TransactionRepository transactionRepository) {
		// TODO Auto-generated constructor stub
		this.transactionRepository=transactionRepository;
	}
	@Override
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
		return transactionRepository.save(transaction);
	}
	@Override
	public List<Transaction> listAllTransactions() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

	

}
