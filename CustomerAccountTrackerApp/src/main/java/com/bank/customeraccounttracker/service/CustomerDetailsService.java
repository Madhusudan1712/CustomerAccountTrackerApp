package com.bank.customeraccounttracker.service;

import com.bank.customeraccounttracker.dto.CheckBalanceDto;
import com.bank.customeraccounttracker.dto.CustomerAccountNumberDto;
import com.bank.customeraccounttracker.dto.CustomerDetailsDto;
import com.bank.customeraccounttracker.model.CustomerDetails;

public interface CustomerDetailsService {
	String createCustomer(CustomerDetailsDto customerDetailsDto);
	CustomerDetails getCutomer(CustomerAccountNumberDto accountNumberDto);
	String editPersonalDetails(CustomerDetailsDto customerDetailsDto);
	CheckBalanceDto checkBalance(CheckBalanceDto balanceDto);
	String deleteByAccountNumber(CustomerAccountNumberDto accountNumberDto);
}
