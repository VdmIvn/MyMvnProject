package SiteUITesting;

import SiteUIPageObject.LoginModal;
import SiteUIPageObject.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutTest extends AbstractTest {

    @Test
    @DisplayName("Log out of the account")
    public void logOut() throws InterruptedException {
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
        mainPage.clickLogOutLink();
        getDriver().navigate().refresh();
        mainPage.clickAccountButton();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(mainPage.getLoginDDLButton()));

        Assertions.assertTrue(mainPage.getLoginDDLButton().isDisplayed());

    }
}
