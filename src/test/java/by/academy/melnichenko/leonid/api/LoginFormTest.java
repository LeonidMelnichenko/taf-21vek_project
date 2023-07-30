package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PageAPI;
import by.itacademy.melnichenko.leonid.api.UserAPI;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginFormTest {
    PageAPI page = new PageAPI();

    @Test
    public void testEnterWithValidCredentials() {
        HashMap<String, UserAPI> validCreds = UserAPI.getValidCredentials();
        page.getLoginResponse(validCreds).assertThat()
                .statusCode(200)
                .header("content-type", equalTo("application/json; charset=UTF-8"))
                .body("location", equalTo("https://www.21vek.by/"))
                .body("user.email", equalTo(validCreds.get("User").getEmail()));
    }

    @Test
    public void testEnterWithInvalidCredentials() {
        HashMap<String, UserAPI> invalidCreds = UserAPI.getInvalidCredentials();
        page.getLoginResponse(invalidCreds).assertThat()
                .statusCode(200)
                .body("error", equalTo("Неправильный пароль"));
    }

    @Test
    public void testEnterWithShortPasswordCredentials() {
        HashMap<String, UserAPI> shortCreds = UserAPI.getShortPasswordCredentials();
        page.getLoginResponse(shortCreds).assertThat()
                .statusCode(200)
                .body("error", equalTo("Неправильный пароль"));
    }

    @Test
    public void testEnterWithIncorrectFormEmail() {
        HashMap<String, UserAPI> incorrectFormatCreds = UserAPI.getIncorrectFormEmailAndAnyPassword();
        page.getLoginResponse(incorrectFormatCreds).assertThat()
                .statusCode(200)
                .header("content-type", containsString("application/json"))
                .body("error", equalTo("Ошибка валидации поля email"));
    }

    @Test
    public void testEnterWithEmptyFields() {
        HashMap<String, UserAPI> emptyCreds = UserAPI.getEmptyFields();
        page.getLoginResponse(emptyCreds)
                .statusCode(200)
                .header("content-type", equalTo("application/json; charset=UTF-8"))
                .body("error", equalTo("Введите email"));
    }
}
