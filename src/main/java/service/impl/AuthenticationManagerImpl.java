package service.impl;

import lib.Component;
import lib.Inject;
import model.Account;
import model.User;
import service.AccountService;
import service.AuthenticationManager;

import java.util.Optional;

@Component
public class AuthenticationManagerImpl implements AuthenticationManager {
    @Inject
    private AccountService accountService;
    private User currentUser;

    @Override
    public boolean hasPermission(String accountNumber) {
        Optional<Account> byNumber = accountService.findByNumber(accountNumber);
        User user = byNumber.get().getUser();
        if (user.equals(currentUser)) {
            return true;
        }
        return false;
    }
}
