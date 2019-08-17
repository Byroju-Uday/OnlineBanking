package com.bank.online.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bank.online.model.Account;
import com.bank.online.service.AccountService;




@Controller
@RequestMapping("/forms")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("account", new Account());
        return "CreateAccount";
    }

    @PostMapping("/register")
    public String registerUser( @Valid @ModelAttribute("account") Account account,
                                BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            System.out.println("Error "+bindingResult.toString());
            return "CreateAccount";
        }
    
        this.accountService.saveAccount(account);
        return "dashboard";
    }
    
    @GetMapping("/listAll")
    public String listAllEmployees(Model model){
        List<Account> accounts = this.accountService.listAllAccounts();
        model.addAttribute("accounts", accounts);
        return "list";
    }

}
