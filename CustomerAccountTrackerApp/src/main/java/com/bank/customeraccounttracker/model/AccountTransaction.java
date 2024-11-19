package com.bank.customeraccounttracker.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String name;
    private Long accountNumber;
    private Date transactionDate = new Date();
    private String transactionType;
    private double transactionAmount;
    private String fromOrToName;
    private Long fromOrToAccountNumber;
    private double totalBalance;
    
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getFromOrToName() {
		return fromOrToName;
	}
	public void setFromOrToName(String fromOrToName) {
		this.fromOrToName = fromOrToName;
	}
	public Long getFromOrToAccountNumber() {
		return fromOrToAccountNumber;
	}
	public void setFromOrToAccountNumber(Long fromOrToAccountNumber) {
		this.fromOrToAccountNumber = fromOrToAccountNumber;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
    
}
