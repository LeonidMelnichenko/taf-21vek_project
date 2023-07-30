package by.academy.melnichenko.leonid.ui.logintest;

import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import by.itacademy.melnichenko.leonid.ui.page.LoginPage;
import by.itacademy.melnichenko.leonid.ui.step.LoginStep;
import by.itacademy.melnichenko.leonid.ui.utils.EmailPasswordFaker;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseLoginTest {
    protected LoginPage page;
    protected LoginStep step;
    protected EmailPasswordFaker faker;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod
    public void warmUp() {
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        page = new LoginPage();
        step = new LoginStep();
        faker = new EmailPasswordFaker(new Faker());
        page.openBaseUrl();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quit();
    }
}
