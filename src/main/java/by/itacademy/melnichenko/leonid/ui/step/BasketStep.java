package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.BasketPage;
import io.qameta.allure.Step;

public class BasketStep {
    BasketPage basketPage;

    public BasketStep() {
        this.basketPage = new BasketPage();
    }

    @Step("Basket step")
    public void fillBasket() {
        basketPage.clickButtonCookies();
        basketPage.clickToButtonCatalog();
        basketPage.clickCategoryHomeAppliances();
        basketPage.clickCategoryRefrige();
        basketPage.clickRefrigeToBasket();
        basketPage.clickBasket();
    }
}
