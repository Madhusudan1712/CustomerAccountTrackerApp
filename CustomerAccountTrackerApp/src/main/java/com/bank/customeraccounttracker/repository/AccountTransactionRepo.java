package com.bank.customeraccounttracker.repository;

import com.bank.customeraccounttracker.model.AccountTransaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long> {
    List<AccountTransaction> findByAccountNumber(Long accountNumber);
}
