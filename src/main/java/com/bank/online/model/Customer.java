package com.bank.online.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



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
	private String dob;
	private long aadharNo;
	private String pancardNo;
	private String emailId;
	private String address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
    private Set<Account> bankAccountSet = new HashSet<>();
	
	
	public Set<Account> getBankAccountSet(){
		return this.bankAccountSet;
	}
	public void setBankAccountSet(Set<Account> bankAccountset)
	{
		this.bankAccountSet = bankAccountSet;
	}
	
	public void addBankAccount(Account account)
    {
    	this.bankAccountSet.add(account);
    	
    }

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


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
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

	public Customer(long customerId, String customerName, String password, long phoneNo, String dob, long aadharNo,
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (aadharNo ^ (aadharNo >>> 32));
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		//result = prime * result + ((bankAccountSet == null) ? 0 : bankAccountSet.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((pancardNo == null) ? 0 : pancardNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phoneNo ^ (phoneNo >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (aadharNo != other.aadharNo)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bankAccountSet == null) {
			if (other.bankAccountSet != null)
				return false;
		} else if (!bankAccountSet.equals(other.bankAccountSet))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (pancardNo == null) {
			if (other.pancardNo != null)
				return false;
		} else if (!pancardNo.equals(other.pancardNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNo != other.phoneNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", dob=" + dob + ", aadharNo=" + aadharNo + ", pancardNo=" + pancardNo
				+ ", emailId=" + emailId + ", address=" + address + ", bankAccountSet=" + bankAccountSet + "]";
	}
}
