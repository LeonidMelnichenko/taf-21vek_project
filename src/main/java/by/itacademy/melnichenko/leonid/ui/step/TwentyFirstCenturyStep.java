package by.itacademy.melnichenko.leonid.ui.step;

import by.itacademy.melnichenko.leonid.ui.page.TwentyFirstCenturyPage;
import org.openqa.selenium.WebDriver;

public class TwentyFirstCenturyStep {
        TwentyFirstCenturyPage page;
        public TwentyFirstCenturyStep(WebDriver driver) {
            page = new TwentyFirstCenturyPage(driver);
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
        public  void fillLoginFormAndSubmit(){
                page.clickButtonAccount();
                page.clickButtonEnter();
                page.clickButtonEnterToLoginForm();
        }
}
