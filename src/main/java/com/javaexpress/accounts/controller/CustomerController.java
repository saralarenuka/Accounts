package com.javaexpress.accounts.controller;

import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.service.IAccountsService;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaexpress.accounts.dto.CustomerDetailsDto;
import com.javaexpress.accounts.service.AccountsServiceImpl;
import com.javaexpress.accounts.service.CustomerServiceImpl;

@RestController
@Slf4j
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private IAccountsService iAccountsService;
    
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/get/{mobileNumber}")
    public ResponseEntity<CustomerDto> fetchAccountDetailsByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {
        log.info("AccountsController :: fetchAccount {}", mobileNumber);
        CustomerDto details = iAccountsService.fetchCustomerDetailsByMobileNumber(mobileNumber);
        if (details != null) {
            return ResponseEntity.ok(details);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
