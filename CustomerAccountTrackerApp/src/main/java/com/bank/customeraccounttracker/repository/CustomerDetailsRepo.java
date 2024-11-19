package com.bank.customeraccounttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.customeraccounttracker.model.CustomerDetails;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Long> {
	CustomerDetails findByAccountNumber(Long accountNumber); // Custom query method
}