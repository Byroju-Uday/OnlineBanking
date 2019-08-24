package com.bank.online.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.online.model.Bank;
import com.bank.online.repository.BankRepository;


@Service
public class BankServiceImpl implements BankService{

    private BankRepository bankRepository;
    
    
    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository=bankRepository;
        
    }
    @Override
    @Transactional
    public Bank saveDetails(Bank bank) {
        // TODO Auto-generated method stub
        return bankRepository.save(bank);
        
    }
	@Override
	@Transactional
	public Bank getDetails() {
		// TODO Auto-generated method stub
		return bankRepository.getOne((long) 1);
	}
    
//  @Override
//  @Transactional
//  public Bank findById(long bankId) {
//      // TODO Auto-generated method stub
//      return this.bankRepository.findById(bankId).get();
//  }
//  
//  @Override
//  @Transactional
//  public List<Bank> listAll() {
//      // TODO Auto-generated method stub
//      List<Bank> list = new ArrayList<>();
//      this.bankRepository.findAll().forEach(bank -> list.add(bank));
//      return list;
//  }
//  
//  @Override
//  @Transactional
//  public void deleteBank(long bankId) {
//      // TODO Auto-generated method stub
//      
//      this.bankRepository.deleteById(bankId);
//      
//  }

    
}
