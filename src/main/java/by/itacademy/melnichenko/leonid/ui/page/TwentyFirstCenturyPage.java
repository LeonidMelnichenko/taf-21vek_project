package by.itacademy.melnichenko.leonid.ui.page;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TwentyFirstCenturyPage {
    private WebDriver webDriver;
    private String url = "https://www.21vek.by/";
    @FindBy (xpath = "//*[@class='userToolsText']")
    private WebElement buttonAccount;
    @FindBy (xpath = "//button[@data-testid='loginButton']")
    private WebElement buttonEnter;
    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@data-testid='loginSubmit']/div[@class='Button-module__buttonText']")
    private WebElement buttonEnterToLoginForm;
    @FindBy(xpath = "//*[@id='modal-cookie']/div/div[2]/div/button[2]/div")
    private WebElement buttonClickToCookies;

    @FindBy(xpath = "//*[@id='header']/div/div[3]/div/button/span)")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//*[@id='header']/div[1]/div[5]/div/div[1]/div[1]/div[1]/a/span")
    private WebElement categoryHouseholdAppliances;

    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/a[2]/span")
    private WebElement categoryFridge;

    @FindBy(xpath = "//*[@id='j-result-page-1']/li[1]/dl/div[2]/form/button")
    private WebElement putRefrigeInBasket;

    @FindBy(xpath = "//*[@id='header']/div/div[3]/div/div[4]/a/span[2]")
    private WebElement buttonBacket;
    public String resultTextAfterInvalidCredentialsLocator = "//span[@class='styles_errorText__3XlSD']";
    public String resultTextAfterIncorrectFormatOfEmail = "//div[@class='input-error-message styles_error__uDzIf']" +
            "/span[@class='input-error-message__message']";
    public String resultWithEmptyEmail = "//form/div/div[2]/div[1]/div[3]/span[2]";
    public String resultWithEmptyPassword = "//form/div/div[2]/div[2]/div[3]/span[2]";

    public TwentyFirstCenturyPage() {
        this.webDriver = DriverSingleton.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void getUrl() {
        webDriver.get(url);
    }

    public void clickButtonAccount() {
        buttonAccount.click();
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

    public void clickButtonCatalog(){
        buttonCatalog.click();
    }
    public void clickCategoryHouseholdAppliances(){
        categoryHouseholdAppliances.click();
    }
    public void clickCategoryFridge(){
        categoryFridge.click();
    }
    public void clickBacket(){
        putRefrigeInBasket.click();
    }

    public void clickButtonBacket(){
        buttonBacket.click();
    }

    public String getErrorText(String locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        WebElement alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return alertText.getText();
    }
    public void clickButtonCookies() {
        buttonClickToCookies.click();
    }
}
