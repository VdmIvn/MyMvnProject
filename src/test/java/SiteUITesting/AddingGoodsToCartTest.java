package SiteUITesting;
import SiteUIPageObject.CartPage;
import SiteUIPageObject.CatalogPage;
import SiteUIPageObject.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddingGoodsToCartTest extends AbstractTest {

    @Test
    @DisplayName("Adding goods to shopping cart")
    public void addToCart() {
        String searchParam = "Холодильники";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.enterSearchParameter(searchParam);

        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.addFirstProduct();
        String firstProductName = catalogPage.getFirstProduct().getText();

        Assertions.assertTrue(mainPage.getCartCounter().isDisplayed());

        catalogPage.addSecondProduct();
        String secondProductName = catalogPage.getSecondProduct().getText();

        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(mainPage.getCartCounter(), "2"));

        mainPage.openCart();

        CartPage cartPage = new CartPage(getDriver());
        String firstCartProduct= cartPage.getFirstCartProduct().getText();
        String secondCartProduct = cartPage.getSecondCartProduct().getText();

        Assertions.assertTrue(firstProductName.equals(firstCartProduct) && secondProductName.equals(secondCartProduct));
    }
}

