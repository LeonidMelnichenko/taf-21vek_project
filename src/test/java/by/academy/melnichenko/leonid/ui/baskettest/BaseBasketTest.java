package by.academy.melnichenko.leonid.ui.baskettest;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import by.itacademy.melnichenko.leonid.ui.page.BasketPage;
import by.itacademy.melnichenko.leonid.ui.step.BasketStep;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseBasketTest {
    BasketPage page;
    BasketStep step;

    @BeforeTest
    public void warmUp() {
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page = new BasketPage();
        step = new BasketStep();
        page.openBaseUrl();
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.quit();
    }
}
