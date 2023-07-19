package by.academy.melnichenko.leonid.ui;

import by.itacademy.melnichenko.leonid.ui.page.TwentyFirstCenturyPage;
import by.itacademy.melnichenko.leonid.ui.step.TwentyFirstCenturyStep;
import by.itacademy.melnichenko.leonid.ui.utils.DemoFaker;
import by.itacademy.melnichenko.leonid.ui.domain.DriverSingleton;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected TwentyFirstCenturyPage page;
    protected TwentyFirstCenturyStep step;
    protected DemoFaker demoFaker;

    @BeforeEach
    public void warmUp() {
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        page = new TwentyFirstCenturyPage();
        step = new TwentyFirstCenturyStep();
        demoFaker = new DemoFaker(new Faker());
        page.getUrl();
    }
    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }
}
