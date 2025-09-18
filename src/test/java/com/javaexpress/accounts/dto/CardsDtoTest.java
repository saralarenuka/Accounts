package com.javaexpress.accounts.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardsDtoTest {

    @Test
    void testCardsDtoFields() {
        CardsDto dto = new CardsDto();
        dto.setMobileNumber("9876543210");
        dto.setCardNumber("1234-5678-9012-3456");
        dto.setCardType("Credit");
        dto.setTotalLimit(100000);
        dto.setAmountUsed(40000);
        dto.setAvailableAmount(60000);

        assertEquals("9876543210", dto.getMobileNumber());
        assertEquals("1234-5678-9012-3456", dto.getCardNumber());
        assertEquals("Credit", dto.getCardType());
        assertEquals(100000, dto.getTotalLimit());
        assertEquals(40000, dto.getAmountUsed());
        assertEquals(60000, dto.getAvailableAmount());
    }
}
