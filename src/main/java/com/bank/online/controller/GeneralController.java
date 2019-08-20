package com.bank.online.controller;

import java.awt.Window;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.online.model.Account;
import com.bank.online.model.Customer;
import com.bank.online.model.Transaction;
import com.bank.online.service.AccountService;
import com.bank.online.service.CustomerService;

@Controller
@RequestMapping("/general")
public class GeneralController {
	
	@Autowired
	public CustomerService customerService;
	
	@Autowired
	public AccountService accountService;
	
	
	@GetMapping(value = "")
	public String showUrlPage(Model model,HttpServletRequest req) {
		
		
		
		return "urlPage";
	}
	
	@GetMapping(value = "/addAccount")
	public String showAddAccountPage(Model model,HttpServletRequest req) {
		
		
		
		return "addAccount";
	}
	@PostMapping(value = "/registerAccount")
	public String registerAccount(Model model,HttpServletRequest req) {
		long customerId = Long.parseLong(req.getParameter("id"));
		String accountType = req.getParameter("accountType");
		long accountBalance = Long.parseLong(req.getParameter("accountBalance"));
		long accountNumber = Long.parseLong(req.getParameter("accountNumber"));
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAccountBalance(accountBalance);
		account.setAccountType(accountType);
		
		Customer customer = customerService.findById(customerId);
		account.setCustomer(customer);
		customer.addBankAccount(account);
		this.customerService.saveCustomer(customer);
		
		
		System.out.println("Account has been created");
		
		return "urlPage";
	}
	
	@GetMapping(value = "/addCustomer")
	public String showAddCustomerPage(Model model,HttpServletRequest req) {
		return "addCustomer";
	}
	
	@PostMapping(value = "/registerCustomer")
	public String registerCustomer(Model model,HttpServletRequest req) {
		//int id = Integer.parseInt(req.getParameter("id"));
		String customerName = req.getParameter("customerName");
		String password = req.getParameter("password");
		long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
		String dob = req.getParameter("dob");
		long aadharNo = Long.parseLong(req.getParameter("aadharNo"));
		String pancardNo = req.getParameter("pancardNo");
		String emailId= req.getParameter("emailId");
		String address= req.getParameter("address");
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setPassword(password);
		customer.setPhoneNo(phoneNo);
		customer.setDob(dob);
		customer.setAadharNo(aadharNo);
		customer.setPancardNo(pancardNo);
		customer.setEmailId(emailId);
		customer.setAddress(address);
		customerService.saveCustomer(customer);
		System.out.println("Customer has been created");
		
		return "urlPage";
	}
	@GetMapping(value = "/addTransaction")
	public String showAddTransactionPage(Model model,HttpServletRequest req) {
	
		return "addTransaction";
	}
	@PostMapping(value = "/registerTransaction")
	public String registerTransaction(Model model,HttpServletRequest req) {
		
		String typeOfTransaction = req.getParameter("typeOfTransaction");
		long transactionAmount = Long.parseLong(req.getParameter("transactionAmount"));
		long fromAccountId = Long.parseLong(req.getParameter("fromAccountId"));
		long toAccountId = Long.parseLong(req.getParameter("toAccountId"));
		
		Account fromAccount = accountService.findById(fromAccountId);
		Account toAccount = accountService.findById(toAccountId);
		long from_user_balance = fromAccount.getAccountBalance();
		long to_user_balance = toAccount.getAccountBalance();
		
		
		Transaction transactionFrom = new Transaction();
		Transaction transactionTo = new Transaction();
		
		if(transactionAmount <= from_user_balance)
		{	long millis=System.currentTimeMillis();  
			java.util.Date date=new java.util.Date(millis); 
			transactionFrom.setAvailableBalance(from_user_balance-transactionAmount);
			transactionFrom.setDate(date);
			transactionFrom.setTimeStamp(millis);
			transactionFrom.setTypeOfTransaction(typeOfTransaction);
			transactionFrom.setTransactionAmount(transactionAmount);
			transactionFrom.setFromAccountId(fromAccountId);
			transactionFrom.setToAccountId(toAccountId);
			transactionFrom.setAccount(fromAccount);
			
			fromAccount.addTransaction(transactionFrom);
			fromAccount.setAccountBalance(transactionFrom.getAvailableBalance());
			toAccount.setAccountBalance(toAccount.getAccountBalance()+transactionAmount);
			
			transactionTo.setAvailableBalance(toAccount.getAccountBalance());
			transactionTo.setDate(date);
			transactionTo.setTimeStamp(millis);
			transactionTo.setTypeOfTransaction("credit");
			transactionTo.setTransactionAmount(transactionAmount);
			transactionTo.setFromAccountId(fromAccountId);
			transactionTo.setToAccountId(toAccountId);
			transactionTo.setAccount(toAccount);
			toAccount.addTransaction(transactionTo);
			
			
			this.accountService.saveAccount(fromAccount);
			this.accountService.saveAccount(toAccount);
			System.out.println("Transaction has been created");
		}
		else
		{
			System.out.println("Unsufficient balance");
		}
		
		return "urlPage";
	}
	
	
	
	
	

}