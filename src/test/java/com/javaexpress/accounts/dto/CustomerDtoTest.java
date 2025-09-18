package com.javaexpress.accounts.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerDtoTest {

    @Test
    void testCustomerDtoConstructorAndFields() {
        CustomerDto dto = new CustomerDto(1L, "Sai", "sai@gmail.com", "9876543210", 100000L);

        assertEquals(1L, dto.getCustomerId());
        assertEquals("Sai", dto.getName());
        assertEquals("sai@gmail.com", dto.getEmail());
        assertEquals("9876543210", dto.getMobileNumber());
        assertEquals(100000L, dto.getAvailable_Balance());
    }

    @Test
    void testCustomerDtoSetters() {
        CustomerDto dto = new CustomerDto();
        dto.setCustomerId(2L);
        dto.setName("Prasanth");
        dto.setEmail("prasanth@gmail.com");
        dto.setMobileNumber("1234567890");
        dto.setAvailable_Balance(200000L);

        assertEquals(2L, dto.getCustomerId());
        assertEquals("Prasanth", dto.getName());
        assertEquals("prasanth@gmail.com", dto.getEmail());
        assertEquals("1234567890", dto.getMobileNumber());
        assertEquals(200000L, dto.getAvailable_Balance());
    }
}
