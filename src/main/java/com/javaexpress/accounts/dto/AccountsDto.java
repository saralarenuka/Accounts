package com.javaexpress.accounts.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountsDto {

	private Long accountNumber;
	private String accountType;
	private String branchAddress;
	private Long customerId;
}
