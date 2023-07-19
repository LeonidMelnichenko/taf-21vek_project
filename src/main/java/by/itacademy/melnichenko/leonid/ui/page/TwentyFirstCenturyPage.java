package by.itacademy.melnichenko.leonid.ui.page;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TwentyFirstCenturyPage {
    private WebDriver webDriver;
    private String url = "https://www.21vek.by/";
    private String buttonAccountLocator = "//*[@class='userToolsText']";
    private String buttonEnterLocator = "//button[@data-testid='loginButton']";
    private String inputEmailLocator = "//input[@id='login-email']";
    private String inputPasswordLocator = "//input[@id='login-password']";
    private String buttonEnterToLoginFormLocator = "//button[@data-testid='loginSubmit']/div[@class='Button-module__" +
            "buttonText']";
    private String buttonClickToCookies = "//*[@id='modal-cookie']/div/div[2]/div/button[2]/div";
    public String resultTextAfterInvalidCredentialsLocator = "//span[@class='styles_errorText__3XlSD']";
    public String resultTextAfterIncorrectFormatOfEmail = "//div[@class='input-error-message styles_error__uDzIf']" +
            "/span[@class='input-error-message__message']";
    public String resultWithEmptyEmail = "//form/div/div[2]/div[1]/div[3]/span[2]";
    public String resultWithEmptyPassword = "//form/div/div[2]/div[2]/div[3]/span[2]";

    public TwentyFirstCenturyPage() {
        this.webDriver = DriverSingleton.getDriver();
    }

    public void getUrl() {
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

    public String getAlertText(String locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        WebElement alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return alertText.getText();
    }
    public void clickButtonCookies() {
        webDriver.findElement(By.xpath(buttonClickToCookies)).click();
    }
}
