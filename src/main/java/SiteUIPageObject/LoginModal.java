package SiteUIPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModal {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='modal']")
    private WebElement modalWindow;

    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"modal\"]//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"modal\"]//span[text() = 'Нет такого аккаунта.']")
    private WebElement wrongEmailAlert;

    public WebElement getWrongEmailAlert() {
        return wrongEmailAlert;
    }

    @FindBy(xpath = "//*[@id=\"modal\"]//span[text() = 'Электронная почта не указана']")
    private WebElement emptyEmailAlert;

    public WebElement getEmptyEmailAlert() {
        return emptyEmailAlert;
    }

    @FindBy(xpath = "//*[@id=\"modal\"]//span[text() = 'Неправильный формат электронной почты']")
    private WebElement wrongEmailFormatAlert;

    public WebElement getWrongEmailFormatAlert() {
        return wrongEmailFormatAlert;
    }

    @FindBy(xpath = "//*[@id=\"modal\"]//span[text() = 'Пароль не указан']")
    private WebElement emptyPasswordAlert;

    public WebElement getEmptyPasswordAlert() {
        return emptyPasswordAlert;
    }

    @FindBy(xpath = "//*[@id=\"modal\"]//span[text() = 'Неправильный пароль.']")
    private WebElement wrongPasswordAlert;

    public WebElement getWrongPasswordAlert() {
        return wrongPasswordAlert;
    }

    public WebElement getModalWindow() {
        return modalWindow;
    }

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public LoginModal clickLogin() {
        loginButton.click();
        return this;


    }
}

