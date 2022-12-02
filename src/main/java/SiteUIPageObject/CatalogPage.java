package SiteUIPageObject;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"j-result-page-1\"]/li[1]/dl/div[1]/dt/a/span[2]")
    private WebElement topGoodDesc;

    @FindBy(xpath = "//*[@id=\"j-result-page-1\"]/li[1]/dl/div[1]/dt/a/span[2]")
    private WebElement topGood;

    @FindBy(xpath = "//li[3]/a/span")
    private WebElement sortLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[4]/ul[1]/li[3]/a/span")
    private WebElement sortLinkDesc;

    @FindBy(xpath = "//*[@id='j-filter__form']/div[3]/dl/div/dd[1]/label")
    private WebElement checkBox1;

    @FindBy(xpath = "//*[@id=\"j-filter__btn\"]")
    private WebElement showGoodsButton;

    @FindBy(name = "filter[price][from]")
    private WebElement priceFieldFrom;

    @FindBy(name = "filter[price][to]")
    private WebElement priceFieldTo;

    @FindBy(xpath = "//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[1]/dl/dt/a/span[2]")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"j-result-page-1\"]/div[1]//li[1]//button")
    private WebElement firstProductButton;

    @FindBy(xpath = "//*[@id=\"j-result-page-1\"]/div[1]/div/ul/li[2]/dl/dt/a/span[2]")
    private WebElement secondProduct;

    @FindBy(xpath = "//*[@id=\"j-result-page-1\"]/div[1]//ul/li[2]//button")
    private WebElement secondProductButton;

    public WebElement getTopGood() {
        return topGood;
    }

    public WebElement getTopGoodDesc() {
        return topGood;
    }

    public WebElement getCheckBox1() {
        return checkBox1;
    }

    public WebElement getSecondProduct() {
        return secondProduct;
    }

    public WebElement getFirstProduct() {
        return firstProduct;
    }

    public CatalogPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstProduct() {
        firstProductButton.click();
    }

    public void addSecondProduct() {
        secondProductButton.click();
    }

    public void tickCheckBox1() {
        checkBox1.click();
    }

    public void fillInPriceFieldFrom(String sum) {
        priceFieldFrom.sendKeys(sum);
    }

    public void fillInPriceFieldTo(String sum) {
        priceFieldTo.sendKeys(sum);
    }

    public void showGoods() {
        showGoodsButton.click();
    }

    public void sortGoods() {
        sortLink.click();
    }

    public void sortGoodsDesc() {
        sortLinkDesc.click();
    }
}
