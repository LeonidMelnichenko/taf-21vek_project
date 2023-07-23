package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.LoginPage;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        loginPage.clickButtonCookies();
        loginPage.clickButtonAccount();
        loginPage.clickButtonEnter();
        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.clickButtonEnterToLoginForm();
    }
}
