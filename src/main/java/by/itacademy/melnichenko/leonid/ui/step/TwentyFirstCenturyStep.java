package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.TwentyFirstCenturyPage;

public class TwentyFirstCenturyStep {
    TwentyFirstCenturyPage page;

    public TwentyFirstCenturyStep() {
        page = new TwentyFirstCenturyPage();
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.clickButtonCookies();
        page.clickButtonAccount();
        page.clickButtonEnter();
        page.setInputEmail(email);
        page.setInputPassword(password);
        page.clickButtonEnterToLoginForm();
    }
}
