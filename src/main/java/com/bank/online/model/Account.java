package com.bank.online.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table
public class Account {
    
	@Id
	@GeneratedValue()
	private long id;
	
	@Column
	private String accountType;
	
	@Column
	private long accountNumber;
	
	@Column
	private long accountBalance;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customerId" , nullable = false)
	private Customer customer;
	
	public Account(){
		
	}
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
    private Set<Transaction> transactionSet = new HashSet<>();
	
	public void addTransaction(Transaction transaction)
    {
    	this.transactionSet.add(transaction);
    	
    }
	public Set<Transaction> getTransactionSet() {
		return transactionSet;
	}

	public void setTransactionSet(Set<Transaction> transactionSet) {
		this.transactionSet = transactionSet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountBalance ^ (accountBalance >>> 32));
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		//result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		//result = prime * result + ((transactionSet == null) ? 0 : transactionSet.hashCode());
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
		Account other = (Account) obj;
		if (accountBalance != other.accountBalance)
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (transactionSet == null) {
			if (other.transactionSet != null)
				return false;
		} else if (!transactionSet.equals(other.transactionSet))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public long getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}