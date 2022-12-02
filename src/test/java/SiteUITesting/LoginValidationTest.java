package SiteUITesting;

import SiteUIPageObject.LoginModal;
import SiteUIPageObject.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginValidationTest extends AbstractTest {

    @Test
    @DisplayName("Login with empty email and password fields")
    void checkValidation1() {
        String email = "";
        String password = "";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAccountButton();
        mainPage.clickLoginDDLButton();

        LoginModal loginModal = new LoginModal(getDriver());
        loginModal.inputEmail(email);
        loginModal.inputPassword(password);
        loginModal.clickLogin();

        Assertions.assertTrue(loginModal.getEmptyEmailAlert().isDisplayed());
        Assertions.assertTrue(loginModal.getEmptyPasswordAlert().isDisplayed());
    }

    @Test
    @DisplayName("Login with invalid password")
    void checkValidation2() {
        String email = "gb-test-vi@mail.ru";
        String password = "123456";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAccountButton();
        mainPage.clickLoginDDLButton();

        LoginModal loginModal = new LoginModal(getDriver());
        loginModal.inputEmail(email);
        loginModal.inputPassword(password);
        loginModal.clickLogin();

        Assertions.assertTrue(loginModal.getWrongPasswordAlert().isDisplayed());
    }

    @Test
    @DisplayName("Login with invalid email format")
    void checkValidation3() {
        String email = "gb-test.ru";
        String password = "123456";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAccountButton();
        mainPage.clickLoginDDLButton();

        LoginModal loginModal = new LoginModal(getDriver());
        loginModal.inputEmail(email);
        loginModal.inputPassword(password);
        loginModal.clickLogin();

        Assertions.assertTrue(loginModal.getWrongEmailFormatAlert().isDisplayed());
    }

    @Test
    @DisplayName("Login with invalid email")
    void checkValidation4() {
        String email = "gb-test@mail.ru";
        String password = "123456";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAccountButton();
        mainPage.clickLoginDDLButton();

        LoginModal loginModal = new LoginModal(getDriver());
        loginModal.inputEmail(email);
        loginModal.inputPassword(password);
        loginModal.clickLogin();

        Assertions.assertTrue(loginModal.getWrongEmailAlert().isDisplayed());
    }

}
