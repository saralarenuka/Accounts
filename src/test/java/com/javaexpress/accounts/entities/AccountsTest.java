package com.javaexpress.accounts.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountsTest {

    @Test
    void testAccountsEntitySettersAndGetters() {
        Accounts account = new Accounts();
        account.setAccountNumber(123456789L);
        account.setCustomerId(987654321L);
        account.setAccountType("Savings");
        account.setBranchAddress("Hyderabad");

        assertEquals(123456789L, account.getAccountNumber());
        assertEquals(987654321L, account.getCustomerId());
        assertEquals("Savings", account.getAccountType());
        assertEquals("Hyderabad", account.getBranchAddress());
    }

    @Test
    void testAccountsEntityConstructor() {
        Accounts account = new Accounts(123456789L, 987654321L, "Savings", "Hyderabad");

        assertNotNull(account);
        assertEquals("Savings", account.getAccountType());
        assertEquals("Hyderabad", account.getBranchAddress());
    }
}
