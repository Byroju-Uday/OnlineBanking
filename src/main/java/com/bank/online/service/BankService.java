package com.bank.online.service;

import java.util.List;

import com.bank.online.model.Bank;


public interface BankService {
    
    Bank saveDetails(Bank bank);

//  //List<Bank> listAll();
    Bank getDetails();
    
    

}
