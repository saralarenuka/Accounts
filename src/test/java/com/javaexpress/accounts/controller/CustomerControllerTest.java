package com.javaexpress.accounts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexpress.accounts.dto.AccountsDto;
import com.javaexpress.accounts.dto.CardsDto;
import com.javaexpress.accounts.dto.CustomerDetailsDto;
import com.javaexpress.accounts.dto.LoansDto;
import com.javaexpress.accounts.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServiceImpl customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFetchCustomerDetails_Success() throws Exception {
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setName("John Doe");
        customerDetailsDto.setEmail("john@example.com");
        customerDetailsDto.setMobileNumber("9999999999");

        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(123456789L);
        accountsDto.setAccountType("Savings");
        accountsDto.setBranchAddress("Hyderabad");
        accountsDto.setCustomerId(1L);
        customerDetailsDto.setAccountsDto(accountsDto);

        Mockito.when(customerService.fetchCustomerDetails(anyString())).thenReturn(customerDetailsDto);

        mockMvc.perform(post("/api/fetchCustomerDetails")
                        .param("mobileNumber", "9999999999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.mobileNumber").value("9999999999"))
                .andExpect(jsonPath("$.accountsDto.accountType").value("Savings"));
    }

    @Test
    void testFetchCustomerDetails_NotFound() throws Exception {
        Mockito.when(customerService.fetchCustomerDetails(anyString())).thenReturn(null);

        mockMvc.perform(post("/api/fetchCustomerDetails")
                        .param("mobileNumber", "0000000000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
