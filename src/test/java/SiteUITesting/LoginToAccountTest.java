package SiteUITesting;

import SiteUIPageObject.LoginModal;
import SiteUIPageObject.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;


public class LoginToAccountTest extends AbstractTest{

    @Test
    @Description("dfgdfgdghdhdgfh")
    @DisplayName("Login with valid credentials")
   void logIn() {

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAccountButton();
        mainPage.clickLoginDDLButton();

        LoginModal loginModal = new LoginModal(getDriver());
        loginModal.inputEmail("gb-test-vi@mail.ru");
        loginModal.inputPassword("qwerty123456");
        loginModal.clickLogin();

        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.invisibilityOf(loginModal.getModalWindow()));
        mainPage.clickAccountButton();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(mainPage.getLogOutLink()));
        Assertions.assertTrue(mainPage.getSubTitle().isDisplayed());

    }
}
