package model;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private User user;
    private BigDecimal balance = new BigDecimal(0);

    public Account(String accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }
}
