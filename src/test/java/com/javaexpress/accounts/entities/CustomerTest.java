package com.javaexpress.accounts.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void testCustomerEntitySettersAndGetters() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setName("Sai Siva Prasanth");
        customer.setEmail("sai@gmail.com");
        customer.setMobileNumber("9876543210");

        assertEquals(1L, customer.getCustomerId());
        assertEquals("Sai Siva Prasanth", customer.getName());
        assertEquals("sai@gmail.com", customer.getEmail());
        assertEquals("9876543210", customer.getMobileNumber());
    }

    @Test
    void testCustomerEntityConstructor() {
        Customer customer = new Customer(1L, "Sai Siva Prasanth", "sai@gmail.com", "9876543210");

        assertNotNull(customer);
        assertEquals("Sai Siva Prasanth", customer.getName());
        assertEquals("sai@gmail.com", customer.getEmail());
        assertEquals("9876543210", customer.getMobileNumber());
    }
}
