package by.itacademy.melnichenko.leonid.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TwentyFirstCenturyPage {
    private WebDriver webDriver;
    private String url = "https://www.21vek.by/";
    private String buttonAccountLocator = "//*[@class='userToolsText']";
    private String buttonEnterLocator = "//button[@data-testid='loginButton']";
    private String inputEmailLocator = "//*[@id='login-email']";
    private String inputPasswordLocator = "//*[@id='login-password']";
    private String buttonEnterToLoginFormLocator = "//button[@data-testid='loginSubmit']";
    private String buttonClickToCookies = "//*[@id='modal-cookie']/div/div[2]/div/button[2]/div";
    private String resultTextAfterInvalidCredentinalsLocator = "//*[@class='styles_errorText__3XlSD']";
    private String resultTextAfterIncorrectFormatOfEmail = "//div[2]/div[1]/div[3]/span[2]";
    private String resultWithEmptyEmail = "//div[1]/div[3]/span[2]";
    private String resultWithEmptyPassword = "//div[2]/div[3]/span[2]";


    public TwentyFirstCenturyPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void getUrl(){
        webDriver.get(url);
        }
    public void clickButtonAccount(){
        webDriver.findElement(By.xpath(buttonAccountLocator)).click();
        }
    public void clickButtonEnter(){
        webDriver.findElement(By.xpath(buttonEnterLocator)).click();
        }
    public void setInputEmail (String email){
        webDriver.findElement(By.xpath(inputEmailLocator)).sendKeys(email);
    }
    public void setInputPassword(String password){
        webDriver.findElement(By.xpath(inputPasswordLocator)).sendKeys(password);
    }
    public void clickButtonEnterToLoginForm(){
        webDriver.findElement(By.xpath(buttonEnterToLoginFormLocator)).click();
    }
    public String getTextAfterInvalidCredentinals(){
        WebElement expectedText = webDriver.findElement(By.xpath(resultTextAfterInvalidCredentinalsLocator));
        return expectedText.getText();
    }
    public String getResultAfterIncorrectFormatOfEmail(){
        WebElement expecterdText = webDriver.findElement(By.xpath(resultTextAfterIncorrectFormatOfEmail));
        return  expecterdText.getText();
    }

    public String getResultWithEmptyEmail(){
        WebElement expectedText = webDriver.findElement(By.xpath(resultWithEmptyEmail));
        return expectedText.getText();
    }
    public String getResultWithEmptyPassword(){
        WebElement expectedText = webDriver.findElement(By.xpath(resultWithEmptyPassword));
        return expectedText.getText();
    }
    public void clickButtonCookies(){
        webDriver.findElement(By.xpath(buttonClickToCookies)).click();
    }
}

