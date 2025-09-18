package com.javaexpress.accounts.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CardsDto {
    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
