package com.bank.customeraccounttracker.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.bank.customeraccounttracker.dto.AccountTransactionDto;
import com.bank.customeraccounttracker.dto.CheckBalanceDto;
import com.bank.customeraccounttracker.dto.CustomerDetailsDto;
import com.bank.customeraccounttracker.model.AccountTransaction;
import com.bank.customeraccounttracker.model.AccountType;
import com.bank.customeraccounttracker.model.CustomerDetails;

public class AllMapper {

    public static CustomerDetailsDto toDto(CustomerDetails customer) {
        CustomerDetailsDto dto = new CustomerDetailsDto();
        dto.setName(customer.getName());
        dto.setMobileNumber(customer.getMobileNumber());
        dto.setEmailId(customer.getEmailId());
        dto.setAddress(customer.getAddress());
        dto.setBankName(customer.getBankName());
        dto.setAccountType(customer.getAccountType().name());
        return dto;
    }

    public static CustomerDetails toEntity(CustomerDetailsDto dto) {
        CustomerDetails customer = new CustomerDetails();
        customer.setName(dto.getName());
        customer.setMobileNumber(dto.getMobileNumber());
        customer.setEmailId(dto.getEmailId());
        customer.setAddress(dto.getAddress());
        customer.setBankName(dto.getBankName());
        customer.setAccountType(dto.getAccountType() != null ? AccountType.valueOf(dto.getAccountType()) : AccountType.SAVINGS);
        return customer;
    }
    
    //find by account number
//    public static CustomerAccountNumberDto toAccountNumberDto(CustomerDetails customer) {
//    	CustomerAccountNumberDto dto = new CustomerAccountNumberDto();
//    	dto.setAccountNumber(customer.getAccountNumber());
//    	return dto;
//    }
//    public static CustomerDetails toAccountNumberEntity(CustomerAccountNumberDto dto) {
//    	CustomerDetails customer = new CustomerDetails();
//    	customer.setAccountNumber(dto.getAccountNumber());
//    	return customer;
//    } 
//    
    public static AccountTransactionDto toTransactionDto(AccountTransaction transaction) {
        AccountTransactionDto dto = new AccountTransactionDto();
        dto.setName(transaction.getName());
        dto.setAccountNumber(transaction.getAccountNumber());
        dto.setTransactionDate(transaction.getTransactionDate());
        dto.setTransactionType(transaction.getTransactionType());
        dto.setTransactionAmount(transaction.getTransactionAmount());
        dto.setFromOrToName(transaction.getFromOrToName());
        dto.setFromOrToAccountNumber(transaction.getFromOrToAccountNumber());
        dto.setTotalBalance(transaction.getTotalBalance());
        return dto;
    }
    
    // method to convert a list of AccountTransaction to a list of AccountTransactionDto
    public static List<AccountTransactionDto> toTransactionDtoList(List<AccountTransaction> transactions) {
        return transactions.stream()
                           .map(AllMapper::toTransactionDto)  // Using the existing method for each item
                           .collect(Collectors.toList());
    }
    
    //edit personal information
//    public static CustomerDetails toPersonalDataEntity(PersonalDataDto dto) {
//    	CustomerDetails customer = new CustomerDetails();
//        customer.setName(dto.getName());
//        customer.setMobileNumber(dto.getMobileNumber());
//        customer.setEmailId(dto.getEmailId());
//        customer.setAddress(dto.getAddress());
//        customer.setBankName(dto.getBankName());
//        customer.setAccountType(dto.getAccountType() != null ? AccountType.valueOf(dto.getAccountType()) : AccountType.SAVINGS);
//        customer.setAccountNumber(dto.getAccountNumber());
//        return customer;
//	}
    
    //check balance
    public static CheckBalanceDto toBalanceDto(CustomerDetails customer) {
    	CheckBalanceDto dto = new CheckBalanceDto();
    	dto.setName(customer.getName());
    	dto.setBankName(customer.getBankName());
    	dto.setAccountNumber(customer.getAccountNumber());
    	dto.setTotalBalance(customer.getTotalBalance()); 
    	return dto;
    }
    
//    public static CustomerDetails toBalanceEntity(CheckBalanceDto dto) {
//    	CustomerDetails customer = new CustomerDetails();
//    	customer.setName(dto.getName());
//    	customer.setBankName(dto.getBankName());
//    	customer.setAccountNumber(dto.getAccountNumber());
//    	customer.setTotalBalance(dto.getTotalBalance()); 
//    	return customer;
//    }
}
