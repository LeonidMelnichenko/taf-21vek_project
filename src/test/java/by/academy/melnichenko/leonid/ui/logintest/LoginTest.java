package by.academy.melnichenko.leonid.ui.logintest;

import by.academy.melnichenko.leonid.ui.logintest.BaseLoginTest;
import by.itacademy.melnichenko.leonid.ui.domain.Errors;
import by.itacademy.melnichenko.leonid.ui.domain.UserUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseLoginTest {

    @Test
    public void testEnterWithValidCredentials() {
        step.fillLoginFormAndSubmit(UserUI.VALID_EMAIL_ACCOUNT, UserUI.VALID_PASSWORD_ACCOUNT);
    }

    @Test
    public void testEnterWithAnyInvalidCredentials() {
        step.fillLoginFormAndSubmit(faker.generateFakerEmail(), faker.genarateFakerPassword());
        Assertions.assertEquals(Errors.NO_ACCOUNT,
                page.getErrorText(page.resultTextAfterInvalidCredentialsLocator));
    }

    @Test
    public void testEnterWithIncorrectFormatOfEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(UserUI.INCORRECT_FORMAT_EMAIL, faker.genarateFakerPassword());
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
