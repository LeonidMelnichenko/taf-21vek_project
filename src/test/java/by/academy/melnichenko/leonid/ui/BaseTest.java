package by.academy.melnichenko.leonid.ui;

import by.itacademy.melnichenko.leonid.ui.page.TwentyFirstCenturyPage;
import by.itacademy.melnichenko.leonid.ui.step.TwentyFirstCenturyStep;
import by.itacademy.melnichenko.leonid.ui.utils.DemoFaker;
import by.itacademy.melnichenko.leonid.ui.utils.DriverSingletone;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    TwentyFirstCenturyPage page;
    TwentyFirstCenturyStep step;
    DemoFaker demoFaker;
    @BeforeEach
    public void warmUp(){
        DriverSingletone.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        page = new TwentyFirstCenturyPage();
        step = new TwentyFirstCenturyStep();
        demoFaker = new DemoFaker(new Faker());
        page.getUrl();
    }
    @AfterEach
    public void tearDown(){
        DriverSingletone.quit();
    }
}
