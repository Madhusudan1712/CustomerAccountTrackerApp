package com.bank.customeraccounttracker.service;

import java.util.List;

import com.bank.customeraccounttracker.dto.AccountTransactionDto;
import com.bank.customeraccounttracker.dto.CustomerAccountNumberDto;
import com.bank.customeraccounttracker.dto.FundTransferRequestDto;
import com.bank.customeraccounttracker.model.AccountTransaction;

public interface AccountTransactionService {
	List<AccountTransactionDto> getTransactionHistory(CustomerAccountNumberDto accountNumberDto);
	String transferFunds(FundTransferRequestDto request);
	List<AccountTransaction> historyByTransId(CustomerAccountNumberDto accountNumberDto);
}
