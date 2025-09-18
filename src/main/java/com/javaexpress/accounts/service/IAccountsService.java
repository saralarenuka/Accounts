package com.javaexpress.accounts.service;

import com.javaexpress.accounts.dto.CustomerDetailsDto;
import com.javaexpress.accounts.dto.CustomerDto;

public interface IAccountsService {

	CustomerDto createAccount(CustomerDto customerDto);

	CustomerDto fetchAccountById(Long id);

	CustomerDto updateAccount(CustomerDto customerDto);
	
	void deleteAccountById(Long id);

	void getAccountDetails();

	CustomerDto fetchCustomerDetailsByMobileNumber(String mobileNumber);


}
