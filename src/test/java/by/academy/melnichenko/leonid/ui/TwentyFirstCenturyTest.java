package by.academy.melnichenko.leonid.ui;

import by.itacademy.melnichenko.leonid.ui.domain.Errors;
import by.itacademy.melnichenko.leonid.ui.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwentyFirstCenturyTest extends BaseTest {

    @Test
    public void testEnterWithValidCredentials() {
        step.fillLoginFormAndSubmit(User.VALID_EMAIL_ACCOUNT, User.VALID_PASSWORD_ACCOUNT);
    }
    @Test
    public void testEnterWithAnyInvalidCredentials() {
        step.fillLoginFormAndSubmit(demoFaker.generateFakerEmail(), demoFaker.genarateFakerPassword());
        Assertions.assertEquals(Errors.NO_ACCOUNT,
                page.getErrorText(page.resultTextAfterInvalidCredentialsLocator));
    }

    @Test
    public void testEnterWithIncorrectFormatOfEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(User.INCORRECT_FORMAT_EMAIL, demoFaker.genarateFakerPassword());
        Assertions.assertEquals(Errors.INVALID_FORMAT_EMAIL,
                page.getErrorText(page.resultTextAfterIncorrectFormatOfEmail));
    }

    @Test
    public void testEnterWithEmptyFields() {
        step.fillLoginFormAndSubmit("", "");
        Assertions.assertEquals(Errors.EMPTY_EMAIL, page.getErrorText(page.resultWithEmptyEmail));
        Assertions.assertEquals(Errors.EMPTY_PASSWORD, page.getErrorText(page.resultWithEmptyPassword));
    }
}
