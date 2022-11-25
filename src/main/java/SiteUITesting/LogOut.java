package SiteUITesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogOut {
    public boolean logOut() {//static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.21vek.by");
        String email = "gb-test-vi@mail.ru";
        String password = "qwerty123456";

        // --------------------------------------------------------PRECONDITION------------------------------------------------------------------

        WebElement accountButton = driver.findElement(By.xpath("//*[@id=\"header\"]//button[@class='styles_userToolsToggler__imcSl']"));
        accountButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"userToolsDropDown\"]/div/div[1]/button"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        passwordField.sendKeys(password);

        WebElement submitCredsButton = driver.findElement(By.xpath("//*[@id=\"modal\"]//button[@type='submit']"));
        submitCredsButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"modal\"]/div/div")));

        // ------------------------------------------------------TC PROCEDURE---------------------------------------------------------------

        WebElement secondAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]//button[@class='styles_userToolsToggler__imcSl']"));
        secondAccountButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"userToolsDropDown\"]//a[@href='/logout/']")));
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id=\"userToolsDropDown\"]//a[@href='/logout/']"));
        logOutButton.click();

        driver.navigate().refresh();

        WebElement thirdAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]//button[@class='styles_userToolsToggler__imcSl']"));
        thirdAccountButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userToolsDropDown\"]/div/div[1]/div")));
        WebElement newLoginButton = driver.findElement(By.xpath("//*[@id=\"userToolsDropDown\"]/div/div[1]/button"));

        if (newLoginButton.isDisplayed()) {
            System.out.println("You're logged out successfully");
            return true;
        } else {
            System.out.println("Something went wrong! Make sure that logging out is performed");
            return false;
        }

       //driver.quit();

    }
}


