package com.bank.online.service;

import java.util.List;
import java.util.Optional;

import com.bank.online.model.Account;
import com.bank.online.model.Customer;

public interface AccountService{
	
public Optional<Account> listById(long accountId);
	
	Account saveAccount(Account account);

	   List<Account> listAll();

	   Account findById(long accountId);

	   void deleteAccount(long accountId);
}
