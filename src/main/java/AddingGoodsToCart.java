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


public class AddingGoodsToCart {
    public static void main(String[] args)  {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://www.21vek.by");

        String searchParam = "Холодильники";

        WebElement searchField = driver.findElement(By.id("catalogSearch"));
        searchField.sendKeys(searchParam);
        searchField.sendKeys(Keys.ENTER);

        String firstProduct = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[1]/dl/dt/a/span[2]")).getText();
        WebElement addToCartButton1 = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//li[1]//button"));
        addToCartButton1.click();

        WebElement cartCounter = driver.findElement(By.xpath("//*[@id=\"header\"]//span[@class='headerCartCount']"));
        if(cartCounter.isDisplayed()) {
            System.out.println(firstProduct + " is added to the shopping cart. Your cart contains " + cartCounter.getText() + " product.");
        }

        String secondProduct = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[2]/dl/dt/a/span[2]")).getText();
        WebElement addToCartButton2 = driver.findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//ul/li[2]//button"));
        addToCartButton2.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"header\"]//span[@class='headerCartCount']"), "2"));

        WebElement cartCounterUPD = driver.findElement(By.xpath("//*[@id=\"header\"]//span[@class='headerCartCount']"));
        System.out.println("\n" + secondProduct + " is added to the shopping cart. There are " + cartCounterUPD.getText() + " products in your cart." + "\n");

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.cssSelector(".headerCartLabel"));
        cartButton.click();

        String firstProductInTheCart = driver.findElement(By.xpath("//*[@id=\"j-basket__items\"]/tbody/tr[1]/td[2]/a")).getText();
        String secondProductInTheCart = driver.findElement(By.xpath("//*[@id=\"j-basket__items\"]/tbody/tr[2]/td[2]/a")).getText();


        if(firstProduct.equals(firstProductInTheCart) && secondProduct.equals(secondProductInTheCart)) {
            System.err.println("Your shopping cart contains the following products:");
            System.out.println("1: " + firstProduct);
            System.out.println("2: " + secondProduct);
        } else {
            System.out.println("Something went wrong. Check your cart.");
        }

        //driver.quit();
    }
}
