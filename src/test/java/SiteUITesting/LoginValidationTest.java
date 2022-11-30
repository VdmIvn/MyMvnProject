package SiteUITesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginValidationTest extends AbstractTest {

    @Test
    @DisplayName("Login with empty email and password fields")
    void checkValidation1() {
        String email = "";
        String password = "";

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();
        getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("//*[@id=\"modal\"]//button[@type='submit']")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"modal\"]//span[text() = 'Электронная почта не указана']")).isDisplayed());
        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"modal\"]//span[text() = 'Пароль не указан']")).isDisplayed());
    }

    @Test
    @DisplayName("Login with invalid password")
    void checkValidation2() {
        String email = "gb-test-vi@mail.ru";
        String password = "123456";

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();
        getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("//*[@id=\"modal\"]//button[@type='submit']")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"modal\"]//span[text() = 'Неправильный пароль.']")).isDisplayed());
    }

    @Test
    @DisplayName("Login with invalid email format")
    void checkValidation3() {
        String email = "gb-test-mail.ru";
        String password = "123456";

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();
        getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("//*[@id=\"modal\"]//button[@type='submit']")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"modal\"]//span[text() = 'Неправильный формат электронной почты']")).isDisplayed());
    }

    @Test
    @DisplayName("Login with invalid email")
    void checkValidation4() {
        String email = "gb-test@mail.ru";
        String password = "123456";

        getDriver().findElement(By.xpath("//button[@class='styles_userToolsToggler__imcSl']")).click();
        getDriver().findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("//*[@id=\"modal\"]//button[@type='submit']")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"modal\"]//span[text() = 'Нет такого аккаунта.']")).isDisplayed());
    }

}
