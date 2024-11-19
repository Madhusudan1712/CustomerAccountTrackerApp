package com.bank.customeraccounttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customeraccounttracker.dto.AccountTransactionDto;
import com.bank.customeraccounttracker.dto.CustomerAccountNumberDto;
import com.bank.customeraccounttracker.dto.CustomerDetailsDto;
import com.bank.customeraccounttracker.dto.FundTransferRequestDto;
import com.bank.customeraccounttracker.mapper.AllMapper;
import com.bank.customeraccounttracker.model.AccountTransaction;
import com.bank.customeraccounttracker.model.CustomerDetails;
import com.bank.customeraccounttracker.repository.AccountTransactionRepo;
import com.bank.customeraccounttracker.repository.CustomerDetailsRepo;

@Service
public class AccountTransactionServiceImpls implements AccountTransactionService {

    @Autowired
    private AccountTransactionRepo transactionRepo;

    @Autowired
    private CustomerDetailsRepo customerRepo;

//    public List<AccountTransactionDto> getTransactionHistory(Long accountNumber) {
//        List<AccountTransaction> transactions = transactionRepo.findByAccountNumber(accountNumber);
//        List<AccountTransactionDto> transactionDtos = new ArrayList<>();
//        transactions.forEach(transaction -> transactionDtos.add(AllMapper.toTransactionDto(transaction)));
//        return transactionDtos;
//    }
    
    //All transaction history by account number
    public List<AccountTransactionDto> getTransactionHistory(CustomerAccountNumberDto accountNumberDto) {
        Long accountNumber = accountNumberDto.getAccountNumber();
        List<AccountTransaction> customerTransactions = transactionRepo.findByAccountNumber(accountNumber);
        
        if (customerTransactions.isEmpty()) {  
            throw new RuntimeException("No transaction found for customer with account number: " + accountNumber);
        }

        // Call the method to map the list of transactions
        return AllMapper.toTransactionDtoList(customerTransactions); 
    }

    //fund transfer if sufficient exits    
    public String transferFunds(FundTransferRequestDto request) {
        //Optional<CustomerDetails> fromAccountOpt = customerRepo.findById(request.getFromAccount());
        //Optional<CustomerDetails> toAccountOpt = customerRepo.findById(request.getToAccount());
        
        CustomerDetails fromAccountOpt = customerRepo.findByAccountNumber(request.getFromAccount());
        CustomerDetails toAccountOpt = customerRepo.findByAccountNumber(request.getToAccount());


        if (fromAccountOpt == null || toAccountOpt == null) {
            return "Invalid account details.";
        }

        CustomerDetails fromAccount = fromAccountOpt;
        CustomerDetails toAccount = toAccountOpt;
        
        if(request.getAmount()<0) {
        	return "Amount can't be negative value";
        }
        else if (fromAccount.getTotalBalance() < request.getAmount()) {
            return "Insufficient balance in the from-account.";
        }

        // Deduct and add funds
        fromAccount.setTotalBalance(fromAccount.getTotalBalance() - request.getAmount());
        toAccount.setTotalBalance(toAccount.getTotalBalance() + request.getAmount());
        customerRepo.save(fromAccount);
        customerRepo.save(toAccount);

        // Record transactions
        AccountTransaction fromTransaction = new AccountTransaction();
        fromTransaction.setAccountNumber(fromAccount.getAccountNumber());
        fromTransaction.setName(fromAccount.getName());
        fromTransaction.setTransactionType("Debit");
        fromTransaction.setTransactionAmount(request.getAmount());
        fromTransaction.setFromOrToName(toAccount.getName());
        fromTransaction.setFromOrToAccountNumber(toAccount.getAccountNumber());
        fromTransaction.setTotalBalance(fromAccount.getTotalBalance());
        transactionRepo.save(fromTransaction);

        AccountTransaction toTransaction = new AccountTransaction();
        toTransaction.setAccountNumber(toAccount.getAccountNumber());
        toTransaction.setName(toAccount.getName());
        toTransaction.setTransactionType("Credit");
        toTransaction.setTransactionAmount(request.getAmount());
        toTransaction.setFromOrToName(fromAccount.getName());
        toTransaction.setFromOrToAccountNumber(fromAccount.getAccountNumber());
        toTransaction.setTotalBalance(toAccount.getTotalBalance());
        transactionRepo.save(toTransaction);

        return "Transfer successful!";
    }
    
    //transaction history by transaction id
    public List<AccountTransaction> historyByTransId(CustomerAccountNumberDto accountNumberDto) {
    	Long accountNumber = accountNumberDto.getAccountNumber();
    	List<AccountTransaction> history = transactionRepo.findByAccountNumber(accountNumber);
    	return history;
	}
}
