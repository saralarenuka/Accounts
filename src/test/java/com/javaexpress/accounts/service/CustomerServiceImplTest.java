package com.javaexpress.accounts.service;

import com.javaexpress.accounts.dto.*;
import com.javaexpress.accounts.entities.Accounts;
import com.javaexpress.accounts.entities.Customer;
import com.javaexpress.accounts.exception.ResourceNotFoundException;
import com.javaexpress.accounts.feignclients.CardsFeignClient;
import com.javaexpress.accounts.feignclients.LoansFeignClient;
import com.javaexpress.accounts.repository.AccountsRepository;
import com.javaexpress.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private CardsFeignClient cardsFeignClient;

    @Mock
    private LoansFeignClient loansFeignClient;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;
    private Accounts accounts;
    private CardsDto cardsDto;
    private LoansDto loansDto;

    @BeforeEach
    void setUp() {
        customer = new Customer(1L, "John Doe", "john@example.com", "9999999999");
        accounts = new Accounts(123456789L, 1L, "Savings", "Hyderabad");

        cardsDto = new CardsDto();
        cardsDto.setCardNumber("CARD123");
        cardsDto.setCardType("Credit");
        cardsDto.setTotalLimit(100000);
        cardsDto.setAmountUsed(20000);
        cardsDto.setAvailableAmount(80000);

        loansDto = new LoansDto();
        loansDto.setLoanNumber("LOAN123");
        loansDto.setLoanType("Home");
        loansDto.setTotalLoan(500000);
        loansDto.setAmountPaid(100000);
        loansDto.setOutstandingAmount(400000);
    }

    @Test
    void testFetchCustomerDetails_Success() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.of(new CustomerDto()));
        when(accountsRepository.findByCustomerId(1L)).thenReturn(Optional.of(accounts));
        when(cardsFeignClient.fetchCardDetails("9999999999")).thenReturn(cardsDto);
        when(loansFeignClient.fetchLoanDetails("9999999999")).thenReturn(loansDto);

        CustomerDetailsDto result = customerService.fetchCustomerDetails("9999999999");

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("Savings", result.getAccountsDto().getAccountType());
        assertEquals("Credit", result.getCardsDto().getCardType());
        assertEquals("Home", result.getLoansDto().getLoanType());
    }

    @Test
    void testFetchCustomerDetails_CustomerNotFound() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            customerService.fetchCustomerDetails("0000000000");
        });

        assertEquals("Customer Mobile Number Not Found 0000000000", exception.getMessage());
    }

    @Test
    void testFetchCustomerDetails_AccountNotFound() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.of(new CustomerDto()));
        when(accountsRepository.findByCustomerId(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            customerService.fetchCustomerDetails("9999999999");
        });

        assertEquals("Account not found for  Mobile Number9999999999", exception.getMessage());
    }
}
