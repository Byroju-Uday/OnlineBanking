package com.bank.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.online.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	
	
}
