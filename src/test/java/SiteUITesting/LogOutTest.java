package SiteUITesting;

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
    public void logOut() {
        String email = "gb-test-vi@mail.ru";
        String password = "qwerty123456";

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();
        getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("//*[@id=\"modal\"]//button[@type='submit']")).click();

        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='modal']")));

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userToolsDropDown\"]")));
        getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//div[text() = 'Выход']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//button")).isDisplayed());

    }
}
