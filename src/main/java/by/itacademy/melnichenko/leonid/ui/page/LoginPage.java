package by.itacademy.melnichenko.leonid.ui.page;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private String url = "https://www.21vek.by/";
    private String buttonAccountLocator = "//*[@class='userToolsText']";
    private String buttonEnterLocator = "//button[@data-testid='loginButton']";
    private String inputEmailLocator = "//input[@id='login-email']";
    private String inputPasswordLocator = "//input[@id='login-password']";
    private String buttonEnterToLoginFormLocator = "//button[@data-testid='loginSubmit']";
    private String buttonClickToCookies = "//div[@class='AgreementCookie_buttons__F4XNa']/button[@class='Button-module__" +
            "button Button-module__blue-primary']";
    public String resultTextAfterInvalidCredentialsLocator = "//span[@class='styles_errorText__3XlSD']";
    public String resultTextAfterIncorrectFormatOfEmail = "//div[@class='input-error-message styles_error__uDzIf']" +
            "/span[@class='input-error-message__message']";
    public String resultWithEmptyEmail = "//form/div/div[2]/div[1]/div[3]/span[2]";
    public String resultWithEmptyPassword = "//form/div/div[2]/div[2]/div[3]/span[2]";

    public LoginPage() {
        this.webDriver = DriverSingleton.getDriver();
    }

    public void openBaseUrl() {
        webDriver.get(url);
    }

    public void clickButtonAccount() {
        webDriver.findElement(By.xpath(buttonAccountLocator)).click();
    }

    public void clickButtonEnter() {
        webDriver.findElement(By.xpath(buttonEnterLocator)).click();
    }

    public void setInputEmail(String email) {
        webDriver.findElement(By.xpath(inputEmailLocator)).sendKeys(email);
    }

    public void setInputPassword(String password) {
        webDriver.findElement(By.xpath(inputPasswordLocator)).sendKeys(password);
    }
    public void clickButtonEnterToLoginForm() {
        webDriver.findElement(By.xpath(buttonEnterToLoginFormLocator)).click();
    }

    public String getErrorText(String locator) {
        return webDriver.findElement(By.xpath(locator)).getText();
    }
    public void clickButtonCookies() {
        webDriver.findElement(By.xpath(buttonClickToCookies)).click();
    }
}
