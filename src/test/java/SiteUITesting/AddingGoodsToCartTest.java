package SiteUITesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddingGoodsToCartTest extends AbstractTest {

    @Test
    @DisplayName("Adding goods to shopping cart")
    public void addToCart() {
        String searchParam = "Холодильники";

        getDriver().findElement(By.id("catalogSearch")).sendKeys(searchParam);
        getDriver().findElement(By.id("catalogSearch")).sendKeys(Keys.ENTER);

        String firstProduct = getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[1]/dl/dt/a/span[2]")).getText();
        getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//li[1]//button")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"header\"]//span[@class='headerCartCount']")).isDisplayed());

        String secondProduct = getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[2]/dl/dt/a/span[2]")).getText();
        getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//ul/li[2]//button")).click();

        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"header\"]//span[@class='headerCartCount']"), "2"));

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.cssSelector(".headerCartLabel")).click();
        String firstProductInTheCart = getDriver().findElement(By.xpath("//*[@id=\"j-basket__items\"]/tbody/tr[1]/td[2]/a")).getText();
        String secondProductInTheCart = getDriver().findElement(By.xpath("//*[@id=\"j-basket__items\"]/tbody/tr[2]/td[2]/a")).getText();

        Assertions.assertTrue(firstProduct.equals(firstProductInTheCart) && secondProduct.equals(secondProductInTheCart));

        }
    }

