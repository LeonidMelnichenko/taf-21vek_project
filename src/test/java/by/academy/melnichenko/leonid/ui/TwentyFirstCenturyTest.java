package by.academy.melnichenko.leonid.ui;

import by.itacademy.melnichenko.leonid.ui.domain.Errors;
import by.itacademy.melnichenko.leonid.ui.domain.UserAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwentyFirstCenturyTest extends BaseTest {

    @Test
    public void testEnterWithValidCredentials() {
        UserAccount user = new UserAccount();
        step.fillLoginFormAndSubmit(user.getValidEmailAccount(), user.getValidPasswordAccount());
    }
    @Test
    public void testEnterWithAnyCorrectEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(demoFaker.generateFakerEmail(), demoFaker.genarateFakerPassword());
        String actualResult = page.getTextAfterInvalidCredentials();
        Assertions.assertEquals(Errors.NO_ACCOUNT, actualResult);
    }

    @Test
    public void testEnterWithIncorrectFormatOfEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit("qwertyui", demoFaker.genarateFakerPassword());
        String actualResult = page.getResultAfterIncorrectFormatOfEmail();
        Assertions.assertEquals(Errors.INVALID_FORMAT_EMAIL, actualResult);
    }

    @Test
    public void testEnterWithEmptyFields() {
        step.fillLoginFormAndSubmit("", "");
        String actualResult = page.getResultWithEmptyEmail();
        String actualresult2 = page.getResultWithEmptyPassword();
        Assertions.assertEquals(Errors.EMPTY_EMAIL, actualResult);
        Assertions.assertEquals(Errors.EMPTY_PASSWORD, actualresult2);
    }
}
