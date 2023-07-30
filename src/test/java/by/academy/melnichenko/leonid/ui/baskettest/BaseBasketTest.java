package by.academy.melnichenko.leonid.ui.baskettest;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import by.itacademy.melnichenko.leonid.ui.page.BasketPage;
import by.itacademy.melnichenko.leonid.ui.step.BasketStep;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseBasketTest {
    protected BasketPage page;
    protected BasketStep step;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod
    public void warmUp() {
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        page = new BasketPage();
        step = new BasketStep();
        page.openBaseUrl();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quit();
    }
}
