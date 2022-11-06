import entity.Accounts;
import enums.EnumGender;
import service.AccountService;
import java.util.Date;

public class App {
    public static void main(String[] args) {


        Accounts Accounts = new Accounts();

        Accounts.setUserName("musa");
        Accounts.setPassword("123456");
        Accounts.setEmail("musa@gmail.com");
        Accounts.setGender(EnumGender.MALE);
        Accounts.setDate(new Date());


        AccountService service = new AccountService();
        Accounts savedAccounts = service.save(Accounts);
        System.out.println(savedAccounts);
    }
}
