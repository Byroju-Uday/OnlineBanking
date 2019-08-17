package com.bank.online.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Account;
import com.bank.online.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository){
		this.accountRepository=accountRepository;
	}
	
	@Override
	@Transactional
	public Account saveAccount(Account account){
	return this.accountRepository.save(account);
	}
	  
	@Override
	@Transactional	
	public List<Account> listAllAccounts(){
		return this.accountRepository.findAll();  
	  }
	  
	@Override
	@Transactional 
	public Account findById(long accId) {
		return this.accountRepository.findById(accId).get();  
	  }
}
