package service.impl;

import model.Account;
import service.AccountService;
import service.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class BankServiceImpl implements BankService {
    private AccountService accountService;

    public BankServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        Optional<Account> sender = accountService.findByNumber(accountFrom);
        Optional<Account> receiver = accountService.findByNumber(accountTo);

        if (sender.isEmpty() || receiver.isEmpty()) {
            throw new RuntimeException("Can't send money from " + accountFrom + " to " + accountTo);
        }

        if (sender.get().getBalance().compareTo(amount) < 0) {
            System.out.println("Not enough money ...");
        }
    }
}
