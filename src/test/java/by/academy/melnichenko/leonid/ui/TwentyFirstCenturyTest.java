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

public class TwentyFirstCenturyTest {
    ChromeDriver chromeDriver;
    TwentyFirstCenturyPage page;
    TwentyFirstCenturyStep step;
    DemoFaker demoFaker;

    @BeforeEach
    public void beforeTest(){
        chromeDriver = new ChromeDriver();
        page = new TwentyFirstCenturyPage(chromeDriver);
        step = new TwentyFirstCenturyStep(chromeDriver);
        demoFaker = new DemoFaker(new Faker());
        page.getUrl();
    }
    @AfterEach
    public void afterTest(){
        chromeDriver.quit();
    }

    @Test
    public void testEnterWithValidCredentials(){
        step.fillLoginFormAndSubmit("majorpayne748@gmail.com", "TzSJ-e@C4YUqniM");
    }
    @Test
    public void testEnterWithAnyCorrectEmailAndAnyPassword(){
        step.fillLoginFormAndSubmit(demoFaker.generateFakerEmail(), demoFaker.genarateFakerPassword());
        String actualResult = page.getTextAfterInvalidCredentinals();
        System.out.println(actualResult);
        Assertions.assertEquals("Нет такого аккаунта. \nЗарегистрироваться?", actualResult);
    }

    @Test
    public  void  testEnterWithIncorrectFormatOfEmailAndAnyPassword(){
        step.fillLoginFormAndSubmit("qwertyui", demoFaker.genarateFakerPassword());
        String actualResult = page.getResultAfterIncorrectFormatOfEmail();
        Assertions.assertEquals("Неправильный формат электронной почты", actualResult);
    }
    @Test
    public void testEnterWithEmptyFields(){
        step.fillLoginFormAndSubmit("", "");
        String actualResult = page.getResultWithEmptyEmail();
        String actualresult2 = page.getResultWithEmptyPassword();
        Assertions.assertEquals("Электронная почта не указана", actualResult);
        Assertions.assertEquals("Пароль не указан", actualresult2);
    }
}
