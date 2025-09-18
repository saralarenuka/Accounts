package com.javaexpress.accounts.repository;

import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindByMobileNumber() {
        Optional<CustomerDto> result = customerRepository.findByMobileNumber("978786768");
        assertTrue(result.isPresent());
        assertEquals("SIVA", result.get().getName());
    }

    @Test
    void testFindByMobileNumber_NotFound() {
        Optional<CustomerDto> result = customerRepository.findByMobileNumber("0000000000");
        assertTrue(result.isEmpty());
    }
}
