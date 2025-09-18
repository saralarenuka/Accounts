package com.javaexpress.accounts.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.javaexpress.accounts.dto.AccountsDto;
import com.javaexpress.accounts.dto.CardsDto;
import com.javaexpress.accounts.dto.CustomerDetailsDto;
import com.javaexpress.accounts.dto.LoansDto;
import com.javaexpress.accounts.entities.Accounts;
import com.javaexpress.accounts.entities.Customer;
import com.javaexpress.accounts.exception.ResourceNotFoundException;
import com.javaexpress.accounts.feignclients.CardsFeignClient;
import com.javaexpress.accounts.feignclients.LoansFeignClient;
import com.javaexpress.accounts.repository.AccountsRepository;
import com.javaexpress.accounts.repository.CustomerRepository;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl {
/*
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        log.info("fetchCustomerDetails");
        /*Customer customer  = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer Mobile Number Not Found "+mobileNumber));

        Accounts accounts  = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account not found for  Mobile Number"+mobileNumber));

        CardsDto cardsDto = cardsFeignClient.fetchCardDetails(mobileNumber);
        LoansDto loansDto = loansFeignClient.fetchLoanDetails(mobileNumber);

        return getCustomerDetailsDto(customer, accounts, cardsDto, loansDto);

        return null;
    }

    private static CustomerDetailsDto getCustomerDetailsDto(Customer customer, Accounts accounts,
                                                            CardsDto cardsDto, LoansDto loansDto) {
        log.info("Setting customer details");
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        BeanUtils.copyProperties(customer, customerDetailsDto);

        AccountsDto accountsDto = new AccountsDto();
        BeanUtils.copyProperties(accounts, accountsDto);
        customerDetailsDto.setAccountsDto(accountsDto);

        setCardDetails(cardsDto, customerDetailsDto);
        setLoansDetails(loansDto, customerDetailsDto);

        log.info("Setting customer details Completed");
        return customerDetailsDto;
    }

    private static void setLoansDetails(LoansDto loansDto, CustomerDetailsDto customerDetailsDto) {
        log.info("Setting loan details");
        if(loansDto !=null) {
            customerDetailsDto.setLoansDto(loansDto);
        }
        log.info("Setting loan details Completed");
    }

    private static void setCardDetails(CardsDto cardsDto, CustomerDetailsDto customerDetailsDto) {
        log.info("Setting card details");
        if(cardsDto !=null){
            customerDetailsDto.setCardsDto(cardsDto);
        }
        log.info("Setting card details Completed");
    }*/
}