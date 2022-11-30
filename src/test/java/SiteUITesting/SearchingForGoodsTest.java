package SiteUITesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SearchingForGoodsTest extends AbstractTest {

    @Test
    @DisplayName("Removing goods from the shopping cart")
    void searchForGood () {

        getDriver().findElement(By.xpath("//*[@id=\"header\"]//button[@class='styles_catalogButton__1K6kI']")).click();
        getDriver().findElement(By.xpath("//span[contains(.,'Бытовая техника')]")).click();
        getDriver().findElement(By.xpath("//h2/a")).click();
        getDriver().findElement(By.xpath("//li[7]/dl/dt/a")).click();
        getDriver().findElement(By.xpath("//*[@id='j-filter__form']/div[3]/dl/div/dd[1]/label")).click();
        getDriver().findElement(By.name("filter[price][from]")).sendKeys("1100");
        getDriver().findElement(By.name("filter[price][to]")).sendKeys("1300");
        getDriver().findElement(By.xpath("//*[@id=\"j-filter__btn\"]")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//span[contains(.,'ATLANT')]")).isDisplayed());
        getDriver().findElement(By.xpath("//li[3]/a/span")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/li[1]/dl/div[2]/span[1]/span[1][@content>='1100']")).isDisplayed());
        getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[4]/ul[1]/li[3]/a/span")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/li[1]/dl/div[2]/span[1]/span[1][@content<='1300']")).isDisplayed());
        Assertions.assertTrue(getDriver().findElement(By.xpath("//span[contains(.,'ATLANT')]")).isDisplayed());
    }
}
