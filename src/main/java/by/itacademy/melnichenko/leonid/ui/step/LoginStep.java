package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.LoginPage;
import io.qameta.allure.Step;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @Step("Navigate to login form")
    public void navigateToLoginForm() {
        loginPage.clickButtonCookies();
        loginPage.clickButtonAccount();
        loginPage.clickButtonEnter();
    }

    @Step("Fill data: email {0} and  password {1}")
    public void fillLoginForm(String email, String password) {
        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
    }

    @Step("Submit login form")
    public void submitLoginForm() {
        loginPage.clickButtonEnterToLoginForm();
    }

    @Step("Check valid account")
    public void enterToValidAccount(){
        loginPage.clickButtonValidAccount();
    }
}
