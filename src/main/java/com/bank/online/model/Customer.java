package com.bank.online.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	
	public Customer(){
		System.out.println("Entered Customer Constructor withOut Parameters");
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerName;
	private String password;
	private long phoneNo;
	private Date dob;
	private long aadharNo;
	private String pancardNo;
	private String emailId;
	private String address;
	
	
	
	

	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public long getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}


	public String getPancardNo() {
		return pancardNo;
	}


	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public Customer(long customerId, String customerName, String password, long phoneNo, Date dob, long aadharNo,
			String pancardNo, String emailId, String address) {
		
		super();
		System.out.println("Entered Customer Constructor with Parameters");
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.aadharNo = aadharNo;
		this.pancardNo = pancardNo;
		this.emailId = emailId;
		this.address = address;
	}

	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", dob=" + dob + ", aadharNo=" + aadharNo + ", pancardNo=" + pancardNo
				+ ", emailId=" + emailId + ", address=" + address + "]";
	}
	
	
	
}
