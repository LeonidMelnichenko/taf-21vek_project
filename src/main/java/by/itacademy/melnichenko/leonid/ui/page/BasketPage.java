package by.itacademy.melnichenko.leonid.ui.page;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    private WebDriver webDriver;
    private String baseUrl = "https://www.21vek.by/";
    @FindBy(xpath = "//button[@class='Button-module__button Button-module__blue-primary']")
    private WebElement buttonCookies;

    @FindBy(xpath = "//*[@id='header']/div/div[3]/div/button")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//a[@href='/kitchen/']")
    private WebElement categoryHomeAppliances;

    @FindBy(xpath = "//a[@href='https://www.21vek.by/refrigerators/']")
    private WebElement categoryRefrige;

    @FindBy(xpath = "//button[@class='g-button g-buybtn result__buybtn cr-buybtn__in j-ga_track']")
    private WebElement refrigeToBasket;

    @FindBy(xpath = "//div[@class='headerCart']")
    private WebElement basket;

    @FindBy(xpath = "//a[@class='BasketItem_title__m55zb']")
    private WebElement refrige;

    public BasketPage() {
        this.webDriver = DriverSingleton.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void openBaseUrl() {
        webDriver.get(baseUrl);
    }

    public void clickToButtonCatalog() {
        buttonCatalog.click();
    }

    public void clickCategoryHomeAppliances() {
        categoryHomeAppliances.click();
    }

    public void clickCategoryRefrige() {
        categoryRefrige.click();
    }

    public void clickRefrigeToBasket() {
        refrigeToBasket.click();
    }

    public void clickBasket() {
        basket.click();
    }

    public void clickButtonCookies() {
        buttonCookies.click();
    }

    public String getFoundRefrigeInBasket() {
        return refrige.getText();
    }
}
