package by.academy.melnichenko.leonid.ui;

import by.itacademy.melnichenko.leonid.ui.utils.Values;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwentyFirstCenturyTest extends BaseTest {
    private String validEmailAccount = "majorpayne748@gmail.com";
    private String validPasswordAccount = "TzSJ-e@C4YUqniM";

    @Test
    public void testEnterWithValidCredentials() {
        step.fillLoginFormAndSubmit(validEmailAccount, validPasswordAccount);
    }

    @Test
    public void testEnterWithAnyCorrectEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(demoFaker.generateFakerEmail(), demoFaker.genarateFakerPassword());
        String actualResult = page.getTextAfterInvalidCredentials();
        Assertions.assertEquals(Values.NO_ACCOUNT.getValues(), actualResult);
    }

    @Test
    public void testEnterWithIncorrectFormatOfEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit("qwertyui", demoFaker.genarateFakerPassword());
        String actualResult = page.getResultAfterIncorrectFormatOfEmail();
        Assertions.assertEquals(Values.INVALID_FORMAT_EMAIL.getValues(), actualResult);
    }

    @Test
    public void testEnterWithEmptyFields() {
        step.fillLoginFormAndSubmit("", "");
        String actualResult = page.getResultWithEmptyEmail();
        String actualresult2 = page.getResultWithEmptyPassword();
        Assertions.assertEquals(Values.EMPTY_EMAIL.getValues(), actualResult);
        Assertions.assertEquals(Values.EMPTY_PASSWORD.getValues(), actualresult2);
    }
}
