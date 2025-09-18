package com.javaexpress.accounts.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoansDto {

    private String mobileNumber;

    private String loanNumber;

    private String loanType;

    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;

}
