package com.javaexpress.accounts.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountsDtoTest {

    @Test
    void testAccountsDtoFields() {
        AccountsDto dto = new AccountsDto();
        dto.setAccountNumber(123456789L);
        dto.setAccountType("Savings");
        dto.setBranchAddress("Hyderabad");
        dto.setCustomerId(987654321L);

        assertEquals(123456789L, dto.getAccountNumber());
        assertEquals("Savings", dto.getAccountType());
        assertEquals("Hyderabad", dto.getBranchAddress());
        assertEquals(987654321L, dto.getCustomerId());
    }
}
