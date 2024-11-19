package com.bank.customeraccounttracker.controller;

import com.bank.customeraccounttracker.dto.AccountTransactionDto;
import com.bank.customeraccounttracker.dto.CustomerAccountNumberDto;
import com.bank.customeraccounttracker.dto.FundTransferRequestDto;
import com.bank.customeraccounttracker.model.AccountTransaction;
import com.bank.customeraccounttracker.service.AccountTransactionServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class AccountTransactionController {

    @Autowired
    private AccountTransactionServiceImpls transactionService;

//    @GetMapping("/{accountNumber}")
//    public ResponseEntity<List<AccountTransactionDto>> getTransactionHistory(@PathVariable Long accountNumber) {
//        List<AccountTransactionDto> transactions = transactionService.getTransactionHistory(accountNumber);
//        if (transactions.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(transactions);
//    }
    
    @GetMapping("/getTransactionsByAccountNumber")
    public List<AccountTransactionDto> getTransactionHistory(@RequestBody CustomerAccountNumberDto accountNumberDto) {
    	return transactionService.getTransactionHistory(accountNumberDto);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestBody FundTransferRequestDto request) {
        String result = transactionService.transferFunds(request);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/historyByTransId")
    public List<AccountTransactionDto> historyByTransId(@RequestBody CustomerAccountNumberDto accountNumberDto) {
    	return transactionService.getTransactionHistory(accountNumberDto);
	}
    
}
