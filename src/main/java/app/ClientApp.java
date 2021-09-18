package app;

import model.Account;
import model.User;
import service.AccountService;
import service.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class ClientApp {
    private BankService bankService;
    private AccountService accountService;
    User currentUser;

    public ClientApp(BankService bankService, AccountService accountService) {
        this.bankService = bankService;
        this.accountService = accountService;
    }

    public void sendMoney(String to, BigDecimal amount) {
        Optional<Account> userAccount = accountService.findByUser(currentUser.getName());
        if (userAccount.isEmpty()) {
            throw new RuntimeException("User dose not have a account");
        }
        bankService.transfer(userAccount.get().getAccountNumber(), to, amount);
    }

    public void login(String login, String password) {
        this.currentUser = new User("Bob", 23);
    }
}
