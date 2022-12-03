package SiteUITesting;

import SiteUIPageObject.CartPage;
import SiteUIPageObject.CatalogPage;
import SiteUIPageObject.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemovingFromTheCartTest extends AbstractTest {

    @Test
    void clearTheCart() throws InterruptedException {

        String searchParam = "Холодильники";
        MainPage mainPage = new MainPage(getDriver());
        mainPage.enterSearchParameter(searchParam);

        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.addFirstProduct();
        Assertions.assertTrue(mainPage.getCartCounter().isDisplayed());
        catalogPage.addSecondProduct();

        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElement(mainPage.getCartCounter(), "2"));
        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(mainPage.getCartLabel()));

        mainPage.openCart();
        CartPage cartPage = new CartPage(getDriver());
        cartPage.deleteFirstProduct();
        //new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(cartPage.getFirstCartProduct()));
        Thread.sleep(3000);
        cartPage.deleteSecondProduct();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(cartPage.getSecondCartProduct()));

        Assertions.assertTrue(cartPage.getBasketContainer().isDisplayed());
    }
}
