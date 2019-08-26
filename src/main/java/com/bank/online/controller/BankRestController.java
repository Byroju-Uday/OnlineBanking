package com.bank.online.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bank.online.model.Bank;
import com.bank.online.service.BankService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class BankRestController {

    @Autowired
    private BankService bankService;
    
	Bank bank;
      
    @GetMapping("/bankdetails")
    public Bank getBankDetails(){
    	bank=new Bank();
    	bank.setBankId(1);
    	bank.setBankName("DBS Bank");
    	bank.setBranchName("Hyderabad");
    	bank.setCountry("India");
    	bank.setIfscCode("DBS00034");
    	bank.setPhone(8934567);
    	bank.setState("Telangana");
    	bank.setStreet("Gachibowli");
    	saveAccount(bank);
        return this.bankService.getDetails();
    }

    public void saveAccount(Bank bank){
	 this.bankService.saveDetails(bank);
    }
    
    
}
