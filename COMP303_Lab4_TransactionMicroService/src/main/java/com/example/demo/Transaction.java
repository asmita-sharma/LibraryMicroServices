package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Transaction 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int transactionId;
	int customerId;
	int bookId;
	@NotEmpty(message = "Transaction Date is required")
	String trxnDate;
	@NotEmpty(message = "Transaction Type is required")
	String trxnType;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTrxnDate() {
		return trxnDate;
	}
	public void setTrxnDate(String trxnDate) {
		this.trxnDate = trxnDate;
	}
	public String getTrxnType() {
		return trxnType;
	}
	public void setTrxnType(String trxnType) {
		this.trxnType = trxnType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", bookId=" + bookId
				+ ", trxnDate=" + trxnDate + ", trxnType=" + trxnType + "]";
	}
}
