package service.impl;

import lib.Component;
import model.Account;
import model.User;
import service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {
    private static final List<Account> accounts = new ArrayList<>();
    static {
        User bob = new User("Bob", 23);
        User alice = new User("Alice", 19);

        Account bobsAccount = new Account("1234", bob);
        Account alicesAccount = new Account("5678", alice);

        accounts.add(bobsAccount);
        accounts.add(alicesAccount);
    }
    @Override
    public Optional<Account> findByNumber(String accountNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst();
    }

    @Override
    public Optional<Account> findByUser(String userName) {
        return accounts.stream().filter(a -> a.getUser().getName().equals(userName)).findFirst();
    }
}
