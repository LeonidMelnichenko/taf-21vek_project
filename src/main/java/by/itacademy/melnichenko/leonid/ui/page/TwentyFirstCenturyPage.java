package by.itacademy.melnichenko.leonid.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwentyFirstCenturyPage {
    private WebDriver webDriver;
    private String buttonAccountLocator = "//*[@id='header']/div/div[3]/div/div[3]/div/div/div/button";
    private String buttonEnterLocator = "//*[@id='userToolsDropDown']/div/div[1]/div[2]/button";
    private String inputEmailLocator = "//*[@id='login-email']";
    private String inputPasswordLocator = "//*[@id='login-password']";
    private String buttonEnterToLoginFormLocator = "//*[@id='default-modal']/div/div/div[2]/div/div/" +
            "form/div/div[2]/div[3]/button";
    private String url = "https://www.21vek.by/";

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
}

