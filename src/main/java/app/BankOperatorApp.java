package app;

import lib.Component;
import service.BankService;

import java.math.BigDecimal;

@Component
public class BankOperatorApp {
    private BankService bankService;

    public void sendMoney(String from, String to, BigDecimal amount) {
        bankService.transfer(from, to, amount);
    }
}
