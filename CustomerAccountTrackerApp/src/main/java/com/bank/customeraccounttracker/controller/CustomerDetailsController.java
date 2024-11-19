package com.bank.customeraccounttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customeraccounttracker.dto.CheckBalanceDto;
import com.bank.customeraccounttracker.dto.CustomerAccountNumberDto;
import com.bank.customeraccounttracker.dto.CustomerDetailsDto;
import com.bank.customeraccounttracker.model.CustomerDetails;
import com.bank.customeraccounttracker.service.CustomerDetailsServiceImpls;

@RestController
@RequestMapping("/api/customers")
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsServiceImpls customerDetailsService;

//    @PostMapping("/create")
//    public ResponseEntity<CustomerDetailsDto> createCustomer(@RequestBody CustomerDetailsDto customerDetailsDto) {
//        CustomerDetailsDto createdCustomer = customerDetailsService.createCustomer(customerDetailsDto);
//        return ResponseEntity.ok(createdCustomer);
//    }
    
    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerDetailsDto customerDetailsDto) {
        //CustomerDetailsDto createdCustomer = customerDetailsService.createCustomer(customerDetailsDto);
        //return ResponseEntity.ok(createdCustomer);
    	return customerDetailsService.createCustomer(customerDetailsDto);
    }
    

    //get full account information by account number

//    @GetMapping("/{accountNumber}")
//    public ResponseEntity<CustomerDetailsDto> getCustomer(@PathVariable Long accountNumber) {
//        Optional<CustomerDetailsDto> customer = customerDetailsService.getCustomer(accountNumber);
//        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
    	
    // only personal information
//    @GetMapping("/CustomerDetailsByAccountNumber")
//    public CustomerDetailsDto getCustomerDetails(@RequestBody CustomerAccountNumberDto accountNumberDto) {
//        return customerDetailsService.getCustomer(accountNumberDto);
//    }
    
    @GetMapping("/CustomerDetailsByAccountNumber")
    public CustomerDetails getCustomerDetailss(@RequestBody CustomerAccountNumberDto accountNumberDto) {
        return customerDetailsService.getCutomer(accountNumberDto);
    }
    
    //edit only personal information by account number
//    public CustomerDetailsDto editPersonalDetails(CustomerAccountNumberDto accountNumberDto) {
//    	return AllMapper.toDto(customerDetailsRepo.findByAccountNumber(accountNumber));
//    }
//    
    //edit personal info
    @PutMapping("/editCustomerDetails")
    public String editPersonalDetails(@RequestBody CustomerDetailsDto customerDetailsDto) {
    	return customerDetailsService.editPersonalDetails(customerDetailsDto);
    }
    
    //check balance by account number
    @GetMapping("/checkBalanceByAccountNumber")
    public CheckBalanceDto checkBalance(@RequestBody CheckBalanceDto balanceDto) {
    	return customerDetailsService.checkBalance(balanceDto);
    }

    //delete account by account number
	@DeleteMapping("/deleteByAccountNumber")
	public String deleteProductById(@RequestBody CustomerAccountNumberDto accountNumberDto) { //DELETE
		return customerDetailsService.deleteByAccountNumber(accountNumberDto);
	}
}
