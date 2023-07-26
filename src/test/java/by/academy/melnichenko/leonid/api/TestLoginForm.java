package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PageAPI;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestLoginForm {
    PageAPI page = new PageAPI();

    @Test
    public void testEnterWithValidСredentials() {
        page.getResponseValidCreds().assertThat()
                .statusCode(302)
                .header("content-type", equalTo("text/html; charset=UTF-8"))
                .header("location", equalTo("https://www.21vek.by/"));
    }

    @Test
    public void testEnterWithInvalidСredentials() {
        page.getResponseInvalidCreds().assertThat()
                .statusCode(200)
                .header("content-type", equalTo("application/json"))
                .body("error", equalTo("Неправильный пароль"));
    }

    @Test
    public void testEnterWithEmptyFields() {
        page.getResponseWithEmptyFields()
                .statusCode(404)
                .header("content-type", equalTo("text/html"));
    }
}
