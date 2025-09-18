package com.javaexpress.accounts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CustomerDetailsDto {

	private String name;
	private String email;
	private String mobileNumber; 
	
	AccountsDto accountsDto;
	LoansDto loansDto;
	CardsDto cardsDto;
}
