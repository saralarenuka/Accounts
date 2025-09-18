package com.javaexpress.accounts.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="HDFCBANK")
@Entity
public class CustomerDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;

	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="mobile_Number")
	private String mobileNumber;

	@Column(name="available_Balance")
	private Long available_Balance;

	public Long getAvailable_Balance() {
		return available_Balance;
	}

	public void setAvailable_Balance(Long available_Balance) {
		this.available_Balance = available_Balance;
	}

	public CustomerDto(Long customerId, String name, String email, String mobileNumber, long available_Balance) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.available_Balance = available_Balance;
	}

	public CustomerDto() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
