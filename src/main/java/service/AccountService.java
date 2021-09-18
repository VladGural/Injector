package service;

import model.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findByNumber(String AccountNumber);

    Optional<Account> findByUser(String userName);
}
