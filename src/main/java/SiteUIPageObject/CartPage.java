package SiteUIPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"j-basket__items\"]/tbody/tr[1]/td[2]/a")
    private WebElement firstCartProduct;

    @FindBy(xpath = "//*[@id=\"j-basket__items\"]/tbody/tr[2]/td[2]/a")
    private WebElement secondCartProduct;

    @FindBy(xpath = "//*[@id=\"j-delete-7061369\"]")
    private WebElement deleteButton1;

    @FindBy(xpath = "//*[@id=\"j-delete-46280\"]")
    private WebElement deleteButton2;

    public WebElement getDeleteButton2() {
        return deleteButton2;
    }

    public WebElement getBasketContainer() {
        return basketContainer;
    }

    @FindBy(xpath = "//*[@id='b-empty-basket-container']")
    private WebElement basketContainer;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstCartProduct() {
        return firstCartProduct;
    }

    public WebElement getSecondCartProduct() {
        return secondCartProduct;
    }

    public void deleteFirstProduct() {
        deleteButton1.click();
    }

    public void deleteSecondProduct() {
        deleteButton2.click();
    }

}
