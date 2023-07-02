package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page._21vekPage;
import org.openqa.selenium.WebDriver;

public class _21vekStep {
        _21vekPage page;
        public _21vekStep(WebDriver driver) {
            page = new _21vekPage(driver);
        }
        public  void fillLoginFormAndSubmit(String email, String password){
                page.clickButtonAccount();
                page.clickButtonEnter();
                page.setInputEmail(email);
                page.setInputPassword(password);
                page.clickButtonEnterToLoginForm();
        }
        public  void fillLoginFormAndSubmit(String email){
                page.clickButtonAccount();
                page.clickButtonEnter();
                page.setInputEmail(email);
                page.clickButtonEnterToLoginForm();
        }
}
