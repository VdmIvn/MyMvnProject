package SiteUIPageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebElement getCartLabel() {
        return cartLabel;
    }

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[3]/div/button")
    private WebElement catalogButton;

    @FindBy(xpath = "//*[@id=\"header\"]//span[@class='styles_categoryName__28yR1 styles_categoryName__ZUtLQ']")
    private WebElement menuItem1;

    @FindBy(xpath = "//*[@id=\"header\"]/div[1]/div[5]/div/div[2]/div[3]/div[1]/div[1]/div[1]/a[8]/span")
    private WebElement menuSubItem;

    @FindBy(id = "catalogSearch")
    private WebElement catalogSearch;

    @FindBy(css = ".headerCartLabel")
    private WebElement cartLabel;

    @FindBy(xpath = "//*[@id=\"header\"]//span[@class='headerCartCount']")
    private WebElement cartCounter;

    public WebElement getCartCounter() {
        return cartCounter;
    }

    @FindBy(xpath = "//button[@class='styles_userToolsToggler__imcSl']")
    private WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"userToolsDropDown\"]//button")
    private WebElement loginDDLButton;

    @FindBy(xpath = "//*[@id=\"userToolsDropDown\"]//a[@href='/logout/']")
    private WebElement logOutLink;

    @FindBy(xpath = "//*[@id=\"userToolsDropDown\"]//span[@class='userToolsSubtitle']")
    private WebElement subTitle;

    public WebElement getMenuItem1() {
        return menuItem1;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickLoginDDLButton() {
        loginDDLButton.click();
    }

    public WebElement getLoginDDLButton() {
        return loginDDLButton;
    }

    public void clickLogOutLink() {
        logOutLink.click();
    }

    public WebElement getLogOutLink() {
        return logOutLink;
    }

    public WebElement getSubTitle() {
        return subTitle;
    }

    public void enterSearchParameter(String param) {
        catalogSearch.sendKeys(param);
        catalogSearch.sendKeys(Keys.ENTER);
    }

    public void openCart() {
        cartLabel.click();
    }

    public void clickCatalogButton() {
        catalogButton.click();
    }

    public void selectMenuSubItem() {
        menuSubItem.click();
    }

}