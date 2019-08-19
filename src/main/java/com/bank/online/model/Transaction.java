package com.bank.online.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;





@Entity
@Table
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	
	private Date date;
	
	private long timeStamp;
   
	private String typeOfTransaction;
    
	private long transactionAmount;
    
	private long availableBalance;
    
	private long fromAccountId;
   
	private long toAccountId;
    
	private String status;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "accountId" , nullable = false)
	private Account account;
	
	public Transaction(){
		
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (int) (availableBalance ^ (availableBalance >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (fromAccountId ^ (fromAccountId >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
		result = prime * result + (int) (toAccountId ^ (toAccountId >>> 32));
		result = prime * result + (int) (transactionAmount ^ (transactionAmount >>> 32));
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		result = prime * result + ((typeOfTransaction == null) ? 0 : typeOfTransaction.hashCode());
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
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (availableBalance != other.availableBalance)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (fromAccountId != other.fromAccountId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		if (toAccountId != other.toAccountId)
			return false;
		if (transactionAmount != other.transactionAmount)
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (typeOfTransaction == null) {
			if (other.typeOfTransaction != null)
				return false;
		} else if (!typeOfTransaction.equals(other.typeOfTransaction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", date=" + date + ", timeStamp=" + timeStamp
				+ ", typeOfTransaction=" + typeOfTransaction + ", transactionAmount=" + transactionAmount
				+ ", availableBalance=" + availableBalance + ", fromAccountId=" + fromAccountId + ", toAccountId="
				+ toAccountId + ", status=" + status + ", account=" + account + "]";
	}
    

    
    
	
}
