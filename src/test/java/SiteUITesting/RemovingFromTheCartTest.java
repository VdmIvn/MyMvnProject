package SiteUITesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemovingFromTheCartTest extends AbstractTest {

    @Test
    void clearTheCart() {
        getDriver().findElement(By.id("catalogSearch")).sendKeys("Холодильники");
        getDriver().findElement(By.id("catalogSearch")).sendKeys(Keys.ENTER);
        getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[1]/dl/dt/a/span[2]")).getText();
        getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//li[1]//button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[2]/dl/dt/a/span[2]")).getText();
        getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/div[1]//ul/li[2]//button")).click();

        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"header\"]//span[@class='headerCartCount']"), "2"));

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.cssSelector(".headerCartLabel")).click();
        getDriver().navigate().refresh();
        getDriver().findElement(By.xpath("//*[@id=\"j-delete-7061369\"]")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"j-delete-7061369\"]")));
        getDriver().findElement(By.xpath("//*[@id=\"j-delete-46280\"]")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"j-delete-46280\"]")));
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-empty-basket-container\"]")));

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id='b-empty-basket-container']")).isDisplayed());
    }
}
