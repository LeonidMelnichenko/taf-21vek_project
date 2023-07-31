package by.itacademy.melnichenko.leonid.ui.page;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver webDriver;
    private String baseUrl = "https://www.21vek.by/";
    @FindBy(xpath = "//*[@class='userToolsText']")
    private WebElement buttonAccount;

    @FindBy(xpath = "//button[@data-testid='loginButton']")
    private WebElement buttonEnter;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@data-testid='loginSubmit']")
    private WebElement buttonEnterToLoginForm;

    @FindBy(xpath = "//div[@class='AgreementCookie_buttons__F4XNa']/button[@class='Button-module__" +
            "button Button-module__blue-primary']")
    private WebElement buttonCookies;

    @FindBy(xpath = "//div[@class='styles_userTools__2J7cp undefined']")
    private WebElement buttonValidAccount;

    @FindBy(xpath = "//*[@class='userToolsSubtitle']")
    private WebElement nameValidAccount;

    public String resultTextAfterInvalidCredentialsLocator = "//span[@class='styles_errorText__3XlSD']";
    public String resultTextAfterIncorrectFormatOfEmail = "//div[@class='input-error-message styles_error__uDzIf']" +
            "/span[@class='input-error-message__message']";
    public String resultWithEmptyEmail = "//form/div/div[2]/div[1]/div[3]/span[2]";
    public String resultWithEmptyPassword = "//form/div/div[2]/div[2]/div[3]/span[2]";

    public LoginPage() {
        this.webDriver = DriverSingleton.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void openBaseUrl() {
        webDriver.get(baseUrl);
    }

    public void clickButtonAccount() {
        buttonAccount.click();
    }
    public void clickButtonValidAccount() {
        buttonValidAccount.click();
    }

    public void clickButtonEnter() {
        buttonEnter.click();
    }

    public void setInputEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickButtonEnterToLoginForm() {
        buttonEnterToLoginForm.click();
    }

    public void clickButtonCookies() {
        buttonCookies.click();
    }

    public String getErrorText(String locator) {
        return webDriver.findElement(By.xpath(locator)).getText();
    }

    public String getFoundValidAccount() {
        return nameValidAccount.getText();
    }
}
