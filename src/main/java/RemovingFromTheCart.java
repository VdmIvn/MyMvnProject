import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RemovingFromTheCart {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://www.21vek.by");


        // --------------------------------------------------------PRECONDITION------------------------------------------------------------------

        String searchParam = "Холодильники";

        WebElement searchField = driver.findElement(By.id("catalogSearch"));
        searchField.sendKeys(searchParam);
        searchField.sendKeys(Keys.ENTER);

        String firstProduct = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[1]/dl/dt/a/span[2]")).getText();
        WebElement addToCartButton1 = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//li[1]//button"));
        addToCartButton1.click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String secondProduct = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[2]/dl/dt/a/span[2]")).getText();
        WebElement addToCartButton2 = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//ul/li[2]//button"));
        addToCartButton2.click();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.cssSelector(".headerCartLabel"));
        cartButton.click();

        String firstProductInTheCart = driver.findElement(By.xpath("//*[@id=\"j-basket__items\"]/tbody/tr[1]/td[2]/a")).getText();
        String secondProductInTheCart = driver.findElement(By.xpath("//*[@id=\"j-basket__items\"]/tbody/tr[2]/td[2]/a")).getText();


        if(firstProduct.equals(firstProductInTheCart) && secondProduct.equals(secondProductInTheCart)) {
            System.out.println("Your shopping cart contains the following products:");
            System.out.println("1: " + firstProductInTheCart);
            System.out.println("2: " + secondProductInTheCart);
        } else {
            System.out.println("Something went wrong. Check your cart.");
        }

        // ------------------------------------------------------TC PROCEDURE---------------------------------------------------------------

        WebElement deleteLink1 = driver.findElement(By.xpath("//*[@id=\"j-delete-7061369\"]"));
        deleteLink1.click();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"j-delete-7061369\"]")));

        System.err.println("\n" + firstProductInTheCart + " is deleted from your cart.");

        WebElement deleteLink2 = driver.findElement(By.xpath("//*[@id=\"j-delete-46280\"]"));
        deleteLink2.click();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"j-delete-46280\"]")));

        System.err.println("\n" + secondProductInTheCart+ " is deleted from your cart.");

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-empty-basket-container\"]")));

        System.out.println("\n" + "Your cart is empty!");

        //driver.quit();
    }
}
