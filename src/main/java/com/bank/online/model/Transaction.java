package com.bank.online.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	
	private Date date;
   
	private String typeOfTransaction;
    
	private long transactionAmount;
    
	private long availableBalance;
    
	private long toCustomerId;
   
	private long fromCustomerId;
    
	private String status;
    
    public Transaction()
    {
    	
    }
    
	public Transaction(long transactionId, Date date, String typeOfTransaction, long transactionAmount,
			long availableBalance, long toCustomerId, long fromCustomerId, String status) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.typeOfTransaction = typeOfTransaction;
		this.transactionAmount = transactionAmount;
		this.availableBalance = availableBalance;
		this.toCustomerId = toCustomerId;
		this.fromCustomerId = fromCustomerId;
		this.status = status;
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

	public void setDate(java.util.Date date1) {
		this.date = date1;
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

	public long getToCustomerId() {
		return toCustomerId;
	}

	public void setToCustomerId(long toCustomerId) {
		this.toCustomerId = toCustomerId;
	}

	public long getFromCustomerId() {
		return fromCustomerId;
	}

	public void setFromCustomerId(long fromCustomerId) {
		this.fromCustomerId = fromCustomerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (availableBalance ^ (availableBalance >>> 32));

		result = prime * result + (int) (fromCustomerId ^ (fromCustomerId >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (toCustomerId ^ (toCustomerId >>> 32));
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
		if (availableBalance != other.availableBalance)
			return false;
		
		if (fromCustomerId != other.fromCustomerId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (toCustomerId != other.toCustomerId)
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
		return "Transaction [transactionId=" + transactionId + ", timeStamp=" + date + ", typeOfTransaction="
				+ typeOfTransaction + ", transactionAmount=" + transactionAmount + ", availableBalance="
				+ availableBalance + ", toCustomerId=" + toCustomerId + ", fromCustomerId=" + fromCustomerId
				+ ", status=" + status +  "]";
	}
    
    
	
}
