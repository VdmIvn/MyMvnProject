package SiteUITesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginToAccountTest {

    @Test
    public void isLoggedIn() {
        LogInToAccount logIn = new LogInToAccount();
        Assertions.assertTrue(logIn.logInToAccount());
    }

}
