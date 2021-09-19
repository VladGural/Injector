package service.impl;

import lib.Inject;
import model.Account;
import service.AccountService;
import service.AuthenticationManager;
import service.BankService;
import service.LogService;

import java.math.BigDecimal;
import java.util.Optional;

public class BankServiceImpl implements BankService {
    @Inject
    private AccountService accountService;
    @Inject
    private AuthenticationManager authenticationManager;
    @Inject
    private LogService logService;

    @Override
    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        logService.log("method transfer is called...");
        Optional<Account> sender = accountService.findByNumber(accountFrom);
        Optional<Account> receiver = accountService.findByNumber(accountTo);

        if (sender.isEmpty() || receiver.isEmpty()) {
            throw new RuntimeException("Can't send money from " + accountFrom + " to " + accountTo);
        }

        if (!authenticationManager.hasPermission(accountFrom)) {
            System.out.println("You can't not send money ...");
        }

        if (sender.get().getBalance().compareTo(amount) < 0) {
            System.out.println("Not enough money ...");
        }
    }
}
