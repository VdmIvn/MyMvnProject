package SiteUITesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogOutTest {

    @Test
    public void isLoggedOut() {
        LogOut logOut = new LogOut();
        Assertions.assertTrue(logOut.logOut());
    }
}
