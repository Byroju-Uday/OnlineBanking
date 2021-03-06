package com.bank.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		this.transactionRepository=transactionRepository;
	}
	@Override
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	@Transactional
	public List<Transaction> listAllTransactions() {
		List<Transaction> list = new ArrayList<>();
		this.transactionRepository.findAll().forEach(transaction -> list.add(transaction));
		return list;
	}

	@Override
	@Transactional
	public Transaction findById(long transactionId) {
		return this.transactionRepository.findById(transactionId).get();
	}

	@Override
	@Transactional
	public void deleteTransaction(long transactionId) {
		this.transactionRepository.deleteById(transactionId);

	}

	//	@Override
	//	public Optional<Transaction> listById(long transactionId) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}



}
