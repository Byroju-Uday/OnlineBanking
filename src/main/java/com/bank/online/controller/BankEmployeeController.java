//package com.bank.online.controller;
//
//import java.io.IOException;
//import java.sql.Date;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.bank.online.model.BankEmployee;
//import com.bank.online.model.Customer;
//import com.bank.online.service.BankEmployeeService;
//
//@Controller
//@RequestMapping("/employee")
//public class BankEmployeeController {
//	
//	@Autowired
//	private BankEmployeeService bankEmployeeService;
//	
//	@GetMapping("/")
//	public String bankLandingPage()
//	{
//		System.out.println("Came inside bankLandingPage function");
//		bankEmployeeService.saveBankEmployee(new BankEmployee());
//		return "onlineBankLanding";
//	}
//	
//	@GetMapping(value="/register")
//	public String showCustomerRegistrationForm(Model model)
//	{
//		System.out.println("Came inside the ShowCustomer");
//		System.out.println("Calling new Customer from get");
//		model.addAttribute("customer", new Customer());
//		System.out.println(model);
//		return "customerRegistration";
//	}
//	
//	@GetMapping(value="/employeeLogin")
//	public String employeeLogin()
//	{
//		return "employeeLogin";
//	}
////	@PostMapping(value="/register")
////	public String customerRegistration( @Valid @ModelAttribute("customer") Customer customer,
////			BindingResult bindingResult) throws IOException
////	{
////		if(bindingResult.hasErrors()){
////            System.out.println("Error "+bindingResult.toString());
////            return "error";
////		}
////		System.out.println("Inside CustomerRegistration");
////		System.out.println(customer);
////		this.customerService.saveCustomer(customer);
////		System.out.println("Records Saved Successfully");
////		return "customerDashboard";
////	}
//	
//		@PostMapping(value="/register")
//		public String customerRegistration(
//				 @RequestParam("customerId")long customerId, 
//				 @RequestParam("customerName")String userName,
//				 @RequestParam("password")String   password,
//				 @RequestParam("emailId")String emailId,
//				 @RequestParam("dob")Date dob,
//				 @RequestParam("inputAddress")String inputAddress,
//				 @RequestParam("aadharNo")long aadharNo,
//				 @RequestParam("pancardNo")String pancardNo,
//				 @RequestParam("phoneNo")long phoneNo,
//				 @Valid @ModelAttribute("customer") Customer customer,
//				BindingResult bindingResult) throws IOException
//		{
//			if(bindingResult.hasErrors()){
//	            System.out.println("Error "+bindingResult.toString());
//	            return "error";
//			}
//			System.out.println("Inside CustomerRegistration");
//			System.out.println(customer);
//			this.bankEmployeeService.saveCustomer(customer);
//			System.out.println("Records Saved Succesfully");
//			return "customerDashboard";
//		}
//		
//		@GetMapping(value="/delete")
//		public String showCustomerDeletionForm()
//		{
//			System.out.println("Came inside the DeleteCustomer");
//			System.out.println("Calling delete Customer from get");
//			return "customerDeletion";
//		}
//		
//		@PostMapping(value="/delete")
//		public String customerDeletion(@RequestParam("customerId")long customerId)
//		{
//			System.out.println("Inside CustomerDeletion");
//			this.bankEmployeeService.deleteCustomer(customerId);
//			System.out.println("Records deleted Succesfully");
//			return "customerDashboard";
//		}
//		
//				
//		@ExceptionHandler(IOException.class)
//	    public String handleException(HttpServletRequest request, Exception ex){
//	        return "customerError";
//	    }
//
//}
