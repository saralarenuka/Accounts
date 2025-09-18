package com.javaexpress.accounts.repository;

import java.util.Optional;

import com.javaexpress.accounts.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.accounts.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Long> {


	Optional<CustomerDto> findByMobileNumber(String mobileNumber);
}
