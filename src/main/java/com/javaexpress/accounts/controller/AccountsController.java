package com.javaexpress.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.service.IAccountsService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class AccountsController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountsController.class);
	@Autowired
	private IAccountsService iAccountsService;
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> createAccount(@RequestBody CustomerDto customerDto) {
		log.info("AccountsController :: createAccount {}", customerDto.getMobileNumber());
		iAccountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
	}

	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<CustomerDto> fetchAccountDetailsById(@PathVariable Long id) {
		log.info("AccountsController :: fetchAccount {}", id);
		CustomerDto details = iAccountsService.fetchAccountById(id);
		if (details != null) {
			return ResponseEntity.ok(details);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> updateAccountDetails(@RequestBody CustomerDto customerDto) {
		log.info("AccountsController :: updateAccountDetails");
		iAccountsService.updateAccount(customerDto);
		return ResponseEntity.ok("Record updated successfully");

	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id) {
		log.info("AccountsController :: deleteAccount {}", id);
		 iAccountsService.deleteAccountById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Record deleted successfully");
	}
}
