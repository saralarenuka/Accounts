package com.javaexpress.accounts.service;

import java.util.Optional;
import java.util.Random;

import com.javaexpress.accounts.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.accounts.dto.AccountsDto;
import com.javaexpress.accounts.dto.CustomerDetailsDto;
import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.entities.Accounts;
import com.javaexpress.accounts.entities.Customer;
import com.javaexpress.accounts.exception.CustomerAlreadyExistsException;
import com.javaexpress.accounts.exception.ResourceNotFoundException;
import com.javaexpress.accounts.repository.AccountsRepository;
import com.javaexpress.accounts.repository.CustomerRepository;

@Service
@Slf4j
public class AccountsServiceImpl implements IAccountsService {

	private static final Logger logger = LoggerFactory.getLogger(AccountsServiceImpl.class);
	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public CustomerDto createAccount(CustomerDto customerDto) {
		return accountsRepository.save(customerDto);

	}

	@Override
	public CustomerDto fetchAccountById(Long id ) {
		return accountsRepository.findById(id).get();
	}

	@Override
	public CustomerDto updateAccount(CustomerDto customerDto) {
		CustomerDto userExists = accountsRepository.findById(customerDto.getCustomerId())
				.orElseThrow(() -> {
					logger.error("User not found with ID: {}", customerDto.getCustomerId());
					return new ResourceNotFoundException("Record not available in DB with ID " + customerDto.getCustomerId());
				});
		userExists.setName(customerDto.getName());
		userExists.setEmail(customerDto.getEmail());
		userExists.setMobileNumber(customerDto.getMobileNumber());
		accountsRepository.save(userExists);
		logger.info("User updated successfully with ID: {}", customerDto.getCustomerId());
		return userExists;
	}

	@Override
	public void deleteAccountById(Long id) {
		accountsRepository.deleteById(id);
	}

	@Override
	public void getAccountDetails() {
		accountsRepository.findAll();
	}

	@Override
	public CustomerDto fetchCustomerDetailsByMobileNumber(String mobileNumber) {
		return customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new CustomerNotFoundException("Customer not found with mobile number: " + mobileNumber));

	}


}



