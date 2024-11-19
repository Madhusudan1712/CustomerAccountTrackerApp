package com.bank.customeraccounttracker.dto;

import java.util.Date;

public class AccountTransactionDto {
    private String name;
    private Long accountNumber;
    private Date transactionDate;
    private String transactionType;
    private double transactionAmount;
    private String fromOrToName;
    private Long fromOrToAccountNumber;
    private double totalBalance;
    
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
