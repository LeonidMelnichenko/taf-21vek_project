package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.LoginPage;
import io.qameta.allure.Step;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @Step("Login step")
    public void fillLoginFormAndSubmit(String email, String password) {
        loginPage.clickButtonCookies();
        loginPage.clickButtonAccount();
        loginPage.clickButtonEnter();
        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.clickButtonEnterToLoginForm();
    }
}
