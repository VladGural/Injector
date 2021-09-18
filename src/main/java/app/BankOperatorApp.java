package app;

import service.BankService;

import java.math.BigDecimal;

public class BankOperatorApp {
    private BankService bankService;

    public void sendMoney(String from, String to, BigDecimal amount) {
        bankService.transfer(from, to, amount);
    }
}
