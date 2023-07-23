package by.academy.melnichenko.leonid.ui.logintest;

import by.itacademy.melnichenko.leonid.ui.page.LoginPage;
import by.itacademy.melnichenko.leonid.ui.step.LoginStep;
import by.itacademy.melnichenko.leonid.ui.utils.EmailPasswordFaker;
import by.itacademy.melnichenko.leonid.ui.driver.DriverSingleton;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseLoginTest {
    protected LoginPage page;
    protected LoginStep step;
    protected EmailPasswordFaker faker;

    @BeforeEach
    public void warmUp() {
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page = new LoginPage();
        step = new LoginStep();
        faker = new EmailPasswordFaker(new Faker());
        page.openBaseUrl();
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }
}
