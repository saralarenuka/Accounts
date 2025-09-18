package com.javaexpress.accounts.service;

import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.exception.ResourceNotFoundException;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountsServiceImplTest {

    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private AccountsServiceImpl accountsService;

    private CustomerDto customerDto;

    @BeforeEach
    void setUp() {
        customerDto = new CustomerDto(1L, "John Doe", "john@example.com", "9999999999",657666646);
    }

    @Test
    void testCreateAccount() {
        when(accountsRepository.save(any(CustomerDto.class))).thenReturn(customerDto);

        CustomerDto result = accountsService.createAccount(customerDto);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(accountsRepository, times(1)).save(customerDto);
    }

    @Test
    void testFetchAccountById() {
        when(accountsRepository.findById(1L)).thenReturn(Optional.of(customerDto));

        CustomerDto result = accountsService.fetchAccountById(1L);

        assertNotNull(result);
        assertEquals("john@example.com", result.getEmail());
        verify(accountsRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateAccount_Success() {
        when(accountsRepository.findById(1L)).thenReturn(Optional.of(customerDto));
        when(accountsRepository.save(any(CustomerDto.class))).thenReturn(customerDto);

        CustomerDto updatedDto = new CustomerDto(1L, "Updated Name", "updated@example.com", "8888888888",9070897);

        CustomerDto result = accountsService.updateAccount(updatedDto);

        assertNotNull(result);
        assertEquals("Updated Name", result.getName());
        verify(accountsRepository, times(1)).save(any(CustomerDto.class));
    }

    @Test
    void testUpdateAccount_NotFound() {
        when(accountsRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            accountsService.updateAccount(customerDto);
        });

        assertEquals("Record not available in DB with ID 1", exception.getMessage());
    }

    @Test
    void testDeleteAccountById() {
        doNothing().when(accountsRepository).deleteById(1L);

        accountsService.deleteAccountById(1L);

        verify(accountsRepository, times(1)).deleteById(1L);
    }
}
