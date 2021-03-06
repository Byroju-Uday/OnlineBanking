package com.bank.online.controller;

import java.awt.Window;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	
	long minimum_balance=3000;
	long DailyTransactionLimit = 3;
	
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
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		account.setLastTransactionDate(date.toString());
		account.setDateTransactionsCount(0);
		account.setAccountNumber(accountNumber);
		account.setAccountBalance(accountBalance);
		account.setAccountType(accountType);
		
		Customer customer = customerService.listById(customerId);
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
	public String registerCustomer(Model model,HttpServletRequest req) throws ParseException {
		//int id = Integer.parseInt(req.getParameter("id"));
		long customerId = Long.parseLong(req.getParameter("customerId"));
		String customerName = req.getParameter("customerName");
		String password = req.getParameter("password");
		long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
		String dob = req.getParameter("dob").toString();
		System.out.println("the date of birth is "+dob);
//		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//		java.util.Date date = sdf1.parse(dob); // Returns a Date format object with the pattern
//        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		long aadharNo = Long.parseLong(req.getParameter("aadharNo"));
		String pancardNo = req.getParameter("pancardNo");
		String emailId= req.getParameter("emailId");
		String address= req.getParameter("address");
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
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
	public String registerTransaction(Model model,HttpServletRequest req) throws ParseException {
		
		String typeOfTransaction = req.getParameter("typeOfTransaction");
		long transactionAmount = Long.parseLong(req.getParameter("transactionAmount"));
		long fromAccountId = Long.parseLong(req.getParameter("fromAccountId"));
		long toAccountId = Long.parseLong(req.getParameter("toAccountId"));
		
		Account fromAccount = accountService.findById(fromAccountId);
		Account toAccount = accountService.findById(toAccountId);
		long from_user_balance = fromAccount.getAccountBalance();
		long to_user_balance = toAccount.getAccountBalance();
		
		
		String fromAccount_date = fromAccount.getLastTransactionDate();
		java.sql.Date cur_date = new java.sql.Date(System.currentTimeMillis());
		long current_date_transactions_count = fromAccount.getDateTransactionsCount();
		
		Transaction transactionFrom = new Transaction();
		Transaction transactionTo = new Transaction();
		
		
		if(fromAccount_date.equals(cur_date.toString()))
		{
			fromAccount.setDateTransactionsCount(current_date_transactions_count+1);
			System.out.println("came in here bro"+ current_date_transactions_count );
		}
		else
		{
			fromAccount.setLastTransactionDate(cur_date.toString());
			fromAccount.setDateTransactionsCount(1);
			System.out.println("fromAccount_date.toString() is "+fromAccount_date.toString());
			System.out.println("cur_date.toString() is "+ cur_date.toString());
			System.out.println("Came into else block as dates are not equal");
			
			// transaction should be done....
		}
		if(current_date_transactions_count < DailyTransactionLimit)
		{
			if(transactionAmount <= from_user_balance && (from_user_balance-transactionAmount)>=minimum_balance)
			{
				
				// transaction should be done.........
					long millis=System.currentTimeMillis();  
					//Timestamp stamp = new Timestamp(System.currentTimeMillis());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					TimeZone timeZone=TimeZone.getTimeZone("IST");
					format.setTimeZone(timeZone);
					Date date1= new Date();
					String date_string = format.format(date1);
					System.out.println("the date of the date_string is "+ date_string);
					Date date_final = format.parse(date_string);
					java.sql.Date date_sql = new java.sql.Date(System.currentTimeMillis());
					System.out.println("date_sql is "+ date_sql);
					
					//java.util.Date date=new java.util.Date(millis); 
					transactionFrom.setUpdatedBalance(from_user_balance-transactionAmount);
					transactionFrom.setDate(date_sql.toString());
					transactionFrom.setTimeStamp(millis);
					transactionFrom.setTypeOfTransaction(typeOfTransaction);
					transactionFrom.setTransactionAmount(transactionAmount);
					transactionFrom.setFromAccountId(fromAccountId);
					transactionFrom.setToAccountId(toAccountId);
					transactionFrom.setAccount(fromAccount);
					
					fromAccount.addTransaction(transactionFrom);
					fromAccount.setAccountBalance(transactionFrom.getUpdatedBalance());
					toAccount.setAccountBalance(toAccount.getAccountBalance()+transactionAmount);
					
					transactionTo.setUpdatedBalance(toAccount.getAccountBalance());
					transactionTo.setDate(date_sql.toString());
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
				// transaction should not be done.........
				System.out.println("low balance to process the transaction");
			}
			
		}
		else
		{
			// transaction should not be done...as out of limit..........
			System.out.println("transaction should not be done...as out of limit..........");
		}
		
		
		return "urlPage";
	}
	
	
	
	
	

}
