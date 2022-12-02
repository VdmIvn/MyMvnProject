package SiteUITesting;

import SiteUIPageObject.CatalogPage;
import SiteUIPageObject.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchingForGoodsTest extends AbstractTest {

    @Test
    @DisplayName("Removing goods from the shopping cart")
    void searchForGood () {

        MainPage mainPage = new MainPage(getDriver());
        Actions actions = new Actions(getDriver());
        mainPage.clickCatalogButton();
        actions.moveToElement(mainPage.getMenuItem1());
        mainPage.selectMenuSubItem();

        CatalogPage catalogPage = new CatalogPage(getDriver());
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(catalogPage.getCheckBox1()));

        catalogPage.tickCheckBox1();
        catalogPage.fillInPriceFieldFrom("1100");
        catalogPage.fillInPriceFieldTo("1300");
        catalogPage.showGoods();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElement(catalogPage.getTopGood(), "ATLANT"));

        Assertions.assertTrue(catalogPage.getTopGood().getText().contains("ATLANT"));

        catalogPage.sortGoods();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(catalogPage.getTopGood()));

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/li[1]/dl/div[2]/span[1]/span[1][@content>='1100']")).isDisplayed());

        catalogPage.sortGoodsDesc();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(catalogPage.getTopGoodDesc()));

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"j-result-page-1\"]/li[1]/dl/div[2]/span[1]/span[1][@content<='1300']")).isDisplayed());
        Assertions.assertTrue(catalogPage.getTopGoodDesc().getText().contains("ATLANT"));

    }
}
