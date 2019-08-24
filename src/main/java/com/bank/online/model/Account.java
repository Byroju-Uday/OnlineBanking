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
	@Column
	private long accountNumber;
	
	@Column
	private String accountType;
	
	@Column
	private long accountBalance;
	@Column
	private String lastTransactionDate;
	
	@Column
	private long dateTransactionsCount;
	
	
	public String getLastTransactionDate() {
		return lastTransactionDate;
	}
	public void setLastTransactionDate(String lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	public long getDateTransactionsCount() {
		return dateTransactionsCount;
	}
	public void setDateTransactionsCount(long dateTransactionsCount) {
		this.dateTransactionsCount = dateTransactionsCount;
	}
	
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
		return true;
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