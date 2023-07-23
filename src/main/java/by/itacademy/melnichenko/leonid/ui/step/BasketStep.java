package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.BasketPage;

public class BasketStep {
    BasketPage basketPage;

    public BasketStep() {
        this.basketPage = new BasketPage();
    }

    public void fillBasket() {
        basketPage.clickButtonCookies();
        basketPage.clickToButtonCatalog();
        basketPage.clickCategoryHomeAppliances();
        basketPage.clickCategoryRefrige();
        basketPage.clickRefrigeToBasket();
        basketPage.clickBasket();
    }
}
