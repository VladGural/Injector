import app.ClientApp;
import service.AccountService;
import service.BankService;
import service.impl.AccountServiceImpl;
import service.impl.BankServiceImpl;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        BankService bankService = new BankServiceImpl(accountService);
        ClientApp clientApp = new ClientApp(bankService, accountService );
        clientApp.login("bob", "1234");
        clientApp.sendMoney("5678", BigDecimal.valueOf(100));
    }
}
