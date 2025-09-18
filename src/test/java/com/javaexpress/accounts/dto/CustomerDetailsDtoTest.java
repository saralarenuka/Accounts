package com.javaexpress.accounts.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerDetailsDtoTest {

    @Test
    void testCustomerDetailsDtoFields() {
        CustomerDetailsDto dto = new CustomerDetailsDto();
        dto.setName("Sai");
        dto.setEmail("sai@gmail.com");
        dto.setMobileNumber("9876543210");

        AccountsDto accountsDto = new AccountsDto();
        LoansDto loansDto = new LoansDto();
        CardsDto cardsDto = new CardsDto();

        dto.setAccountsDto(accountsDto);
        dto.setLoansDto(loansDto);
        dto.setCardsDto(cardsDto);

        assertEquals("Sai", dto.getName());
        assertEquals("sai@gmail.com", dto.getEmail());
        assertEquals("9876543210", dto.getMobileNumber());
        assertNotNull(dto.getAccountsDto());
        assertNotNull(dto.getLoansDto());
        assertNotNull(dto.getCardsDto());
    }
}
