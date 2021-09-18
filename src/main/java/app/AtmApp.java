package app;

import model.Account;
import model.User;
import service.AccountService;
import service.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class AtmApp {
    private BankService bankService;
    private AccountService accountService;
    private User currentUser;

    public void sendMoney(String to, BigDecimal amount) {
        Optional<Account> userAccount = accountService.findByUser(currentUser.getName());
        if (userAccount.isEmpty()) {
            throw new RuntimeException("User dose not have a account");
        }
        bankService.transfer(userAccount.get().getAccountNumber(), to, amount);
    }

    public void login(String phoneNumber) {
        this.currentUser = new User("Bob", 23);
    }
}
