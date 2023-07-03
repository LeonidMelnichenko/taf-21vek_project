package by.academy.melnichenko.leonid.ui;

import by.itacademy.melnichenko.leonid.ui.page.TwentyFirstCenturyPage;
import by.itacademy.melnichenko.leonid.ui.step.TwentyFirstCenturyStep;
import by.itacademy.melnichenko.leonid.ui.utils.DemoFaker;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TwentyFirstCenturyTest {
    ChromeDriver chromeDriver;
    TwentyFirstCenturyPage page;
    TwentyFirstCenturyStep step;
    DemoFaker demoFaker;

    @BeforeEach
    public void beforeTest() throws InterruptedException {
        chromeDriver = new ChromeDriver();
        page = new TwentyFirstCenturyPage(chromeDriver);
        step = new TwentyFirstCenturyStep(chromeDriver);
        demoFaker = new DemoFaker(new Faker());
//        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.getUrl();

        Thread.sleep(30000);

    }
    @AfterEach
    public void afterTest(){
        chromeDriver.quit();
    }
    @Test
    public void testEnterWithIncorrectEmailAndPassword(){
        step.fillLoginFormAndSubmit(demoFaker.generateFakerEmail(), demoFaker.genarateFakerPassword());
        String actualResult = page.getResulttextAfterIncorrectEnter();
        Assertions.assertEquals("Неправильный пароль. ", actualResult);
    }
}
