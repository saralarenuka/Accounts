package com.javaexpress.accounts.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoansDtoTest {

    @Test
    void testLoansDtoFields() {
        LoansDto dto = new LoansDto();
        dto.setMobileNumber("9876543210");
        dto.setLoanNumber("LN123456");
        dto.setLoanType("Home");
        dto.setTotalLoan(500000);
        dto.setAmountPaid(200000);
        dto.setOutstandingAmount(300000);

        assertEquals("9876543210", dto.getMobileNumber());
        assertEquals("LN123456", dto.getLoanNumber());
        assertEquals("Home", dto.getLoanType());
        assertEquals(500000, dto.getTotalLoan());
        assertEquals(200000, dto.getAmountPaid());
        assertEquals(300000, dto.getOutstandingAmount());
    }
}
