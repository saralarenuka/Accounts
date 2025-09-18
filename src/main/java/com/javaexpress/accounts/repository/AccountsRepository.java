package com.javaexpress.accounts.repository;

import java.util.Optional;

import com.javaexpress.accounts.dto.CustomerDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.javaexpress.accounts.entities.Accounts;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<CustomerDto, Long> {

	Optional<Accounts> findByCustomerId(Long customerId);

	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);
}
