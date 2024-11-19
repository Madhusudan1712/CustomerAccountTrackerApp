package com.bank.customeraccounttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customeraccounttracker.dto.CheckBalanceDto;
import com.bank.customeraccounttracker.dto.CustomerAccountNumberDto;
import com.bank.customeraccounttracker.dto.CustomerDetailsDto;
import com.bank.customeraccounttracker.mapper.AllMapper;
import com.bank.customeraccounttracker.model.CustomerDetails;
import com.bank.customeraccounttracker.repository.CustomerDetailsRepo;


@Service
public class CustomerDetailsServiceImpls implements CustomerDetailsService{

    @Autowired
    private CustomerDetailsRepo customerDetailsRepo;

    //create account
//    public CustomerDetailsDto createCustomer(CustomerDetailsDto customerDetailsDto) {
//        CustomerDetails customer = AllMapper.toEntity(customerDetailsDto);
//        customer = customerDetailsRepo.save(customer);
//        return AllMapper.toDto(customer);
//    }
    
    //create account
    public String createCustomer(CustomerDetailsDto customerDetailsDto) {
    	if(customerDetailsDto.getAccountNumber() != null) {
    		return "Remove account number, its is auto generated";
    	}
        CustomerDetails customer = AllMapper.toEntity(customerDetailsDto);
        customerDetailsRepo.save(customer);
        return "Account Created successfully";
    }
    
    //get full customer information
    public CustomerDetails getCutomer(CustomerAccountNumberDto accountNumberDto) {
    	Long accountNumber = accountNumberDto.getAccountNumber();
//    	boolean accountExits = customerDetailsRepo.existsById(accountNumber);
//		if (accountExits) {
//		  throw new RuntimeException("Customer with account number " + accountNumber + " not found.");
//		}
    	
		//return customerDetailsRepo.findById(accountNumber).orElse(new CustomerDetails());
		return customerDetailsRepo.findByAccountNumber(accountNumber);
    }


//    public Optional<CustomerDetailsDto> getCustomer(Long accountNumber) {
//        return customerDetailsRepo.findById(accountNumber).map(AllMapper::toDto);
//    }
    
    //get customer account (only personal information) by account number
//    public CustomerDetailsDto getCustomer(CustomerAccountNumberDto accountNumberDto) {
//        Long accountNumber = accountNumberDto.getAccountNumber();
//        CustomerDetails customer = customerDetailsRepo.findByAccountNumber(accountNumber);
//
//        if (customer == null) {
//            throw new RuntimeException("Customer with account number " + accountNumber + " not found.");
//        }
//
//        return AllMapper.toDto(customer);
//    }
    
    //edit only personal information by account number
//    public String editPersonalDetails(PersonalDataDto personalDataDto) {
//    	Long accountNumber = personalDataDto.getAccountNumber();
//    	
//    	CustomerDetails existingCustomer = customerDetailsRepo.findByAccountNumber(accountNumber);
//    	
//    	if(existingCustomer == null) {
//    		return "Account number does't exits, Update failed..!";
//    	}
//    	else {
//    		CustomerDetails customer = AllMapper.toPersonalDataEntity(personalDataDto);
//    		//CustomerDetails customer = customerDetailsRepo.findByAccountNumber(accountNumber);
//    		customerDetailsRepo.save(customer);
//    		return "Updated successfully";
//    	}
//    }
    
    //edit only personal information by account number
    public String editPersonalDetails(CustomerDetailsDto customerDetailsDto) {
    	Long accountNumber = customerDetailsDto.getAccountNumber();
    	if(accountNumber == null) {
    		return "Please provide the account number to update";
    	}
    	
    	CustomerDetails existingCustomer = customerDetailsRepo.findByAccountNumber(accountNumber);
    	if(existingCustomer == null) {
    		return "Account number does't exits, Update failed...!";
    	}
    	
    	CustomerDetails customer = AllMapper.toEntity(customerDetailsDto);
    	customerDetailsRepo.save(customer);
    	return "Updated successfully";
	}
    

    //check balance by account number -----------------------------------------------
    public CheckBalanceDto checkBalance(CheckBalanceDto balanceDto) {
    	Long accountNumber = balanceDto.getAccountNumber();
    	CustomerDetails balanceDetails = customerDetailsRepo.findByAccountNumber(accountNumber);
    	
    	if (balanceDetails == null) {
            return null;
        }

    	return AllMapper.toBalanceDto(balanceDetails);
    }
    
    //delete customer account by account number
    public String deleteByAccountNumber(CustomerAccountNumberDto accountNumberDto) {
    	Long accountNumber = accountNumberDto.getAccountNumber();
    	boolean accountExits = customerDetailsRepo.existsById(accountNumber);
    	if(accountExits) {
	    	customerDetailsRepo.deleteById(accountNumber);
	    	return "Account deleted successfulluy";
    	}
    	else {
    		return "Account Number does not exits";
		}
	}
    
}
