package com.bank.online.service;

import java.util.List;

import com.bank.online.model.Account;

public interface AccountService{
	
  Account saveAccount(Account account);
  
  List<Account> listAllAccounts();
  
  Account findById(long accId);
}
