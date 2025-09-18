package com.javaexpress.accounts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.service.IAccountsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountsController.class)
public class AccountsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAccountsService accountsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAccount() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "John Doe", "john@example.com", "9999999999",97897);

        Mockito.when(accountsService.createAccount(any(CustomerDto.class)))
                .thenReturn(customerDto);

        mockMvc.perform(post("/api/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Account created successfully"));
    }

    @Test
    void testFetchAccountDetailsById() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "John Doe", "john@example.com", "9999999999",987);

        Mockito.when(accountsService.fetchAccountById(1L)).thenReturn(customerDto);

        mockMvc.perform(get("/api/fetch/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.mobileNumber").value("9999999999"));
    }

    @Test
    void testUpdateAccountDetails() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "John Updated", "updated@example.com", "8888888888",978);

        Mockito.when(accountsService.updateAccount(any(CustomerDto.class))).thenReturn(customerDto);

        mockMvc.perform(put("/api/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Record updated successfully"));
    }

    @Test
    void testDeleteAccountById() throws Exception {
        Mockito.doNothing().when(accountsService).deleteAccountById(1L);

        mockMvc.perform(delete("/api/delete/1"))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Record deleted successfully"));
    }
}
