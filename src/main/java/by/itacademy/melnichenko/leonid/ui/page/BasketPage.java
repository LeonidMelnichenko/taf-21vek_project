package by.itacademy.melnichenko.leonid.ui.page;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private WebDriver webDriver;
    private String baseUrl = "https://www.21vek.by/";
    private String buttonClickToCookiesLocator = "//button[@class='Button-module__button Button-module__blue-primary']";
    private String buttonCatalogLocator = "//*[@id='header']/div/div[3]/div/button";
    private String categoryHomeAppliancesLocator = "//a[@href='/kitchen/']";
    private String categoryRefrigeLocator = "//a[@href='https://www.21vek.by/refrigerators/']";
    private String refrigeToBasketLocator = "//button[@class='g-button g-buybtn result__buybtn cr-buybtn__in j-ga_track']";
    private String basketLocator = "//div[@class='headerCart']";
    private String nameRefrigeLocator = "//a[@class='BasketItem_title__m55zb']";

    public BasketPage() {
        this.webDriver = DriverSingleton.getDriver();
    }

    public void openBaseUrl() {
        webDriver.get(baseUrl);
    }

    public void clickToButtonCatalog() {
        webDriver.findElement(By.xpath(buttonCatalogLocator)).click();
    }

    public void clickCategoryHomeAppliances() {
        webDriver.findElement(By.xpath(categoryHomeAppliancesLocator)).click();
    }

    public void clickCategoryRefrige() {
        webDriver.findElement(By.xpath(categoryRefrigeLocator)).click();
    }

    public void clickRefrigeToBasket() {
        webDriver.findElement(By.xpath(refrigeToBasketLocator)).click();
    }

    public void clickBasket() {
        webDriver.findElement(By.xpath(basketLocator)).click();
    }

    public void clickButtonCookies() {
        webDriver.findElement(By.xpath(buttonClickToCookiesLocator)).click();
    }

    public String getFoundRefrigeInBasket() {
        return webDriver.findElement(By.xpath(nameRefrigeLocator)).getText();
    }
}
