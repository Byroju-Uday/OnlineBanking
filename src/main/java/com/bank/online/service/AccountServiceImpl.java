package com.bank.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Account;
import com.bank.online.repository.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	
	@Override
	@Transactional
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	
	@Override
	@Transactional
	public List<Account> listAll() {
		// TODO Auto-generated method stub
		List<Account> list = new ArrayList<>();
    	this.accountRepository.findAll().forEach(account -> list.add(account));
    	return list;
	}
	
	@Override
	@Transactional
	public Account findById(long accountId) {
		// TODO Auto-generated method stub
		return this.accountRepository.findById(accountId).get();
	}

	@Override
	@Transactional
	public void deleteAccount(long accountId) {
		// TODO Auto-generated method stub
		System.out.println("Deleting account based on Id");
		this.accountRepository.deleteById(accountId);
		
	}

	@Override
	public Optional<Account> listById(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
}
