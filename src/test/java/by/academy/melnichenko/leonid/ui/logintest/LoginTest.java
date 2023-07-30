package by.academy.melnichenko.leonid.ui.logintest;

import by.itacademy.melnichenko.leonid.ui.domain.Errors;
import by.itacademy.melnichenko.leonid.ui.domain.UserUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseLoginTest {

    @Test
    public void testEnterWithValidCredentials() {
        step.fillLoginFormAndSubmit(UserUI.VALID_EMAIL_ACCOUNT, UserUI.VALID_PASSWORD_ACCOUNT);
    }

    @Test
    public void testEnterWithAnyInvalidCredentials() {
        step.fillLoginFormAndSubmit(faker.generateFakerEmail(), faker.genarateFakerPassword());
        Assert.assertEquals(Errors.NO_ACCOUNT,
                page.getErrorText(page.resultTextAfterInvalidCredentialsLocator));
    }

    @Test
    public void testEnterWithIncorrectFormatOfEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(UserUI.INCORRECT_FORMAT_EMAIL, faker.genarateFakerPassword());
        Assert.assertEquals(Errors.INVALID_FORMAT_EMAIL,
                page.getErrorText(page.resultTextAfterIncorrectFormatOfEmail));
    }

    @Test
    public void testEnterWithEmptyFields() {
        step.fillLoginFormAndSubmit("", "");
        Assert.assertEquals(Errors.EMPTY_EMAIL, page.getErrorText(page.resultWithEmptyEmail));
        Assert.assertEquals(Errors.EMPTY_PASSWORD, page.getErrorText(page.resultWithEmptyPassword));
    }
}
