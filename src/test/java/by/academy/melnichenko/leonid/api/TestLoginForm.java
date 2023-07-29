package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PageAPI;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestLoginForm {
    PageAPI page = new PageAPI();

    @Test
    public void testEnterWithValidСredentials() {
        page.getResponseWithValidCreds().assertThat()
                .statusCode(200)
                .header("content-type", equalTo("application/json; charset=UTF-8"))
                .body("location", equalTo("https://www.21vek.by/?utm_source=google&utm_medium=cpc&utm_" +
                        "campaign=336837170&utm_content=20888055050|596687804571&utm_term=21%20vek&gclid=CjwKCAjwzo2m" +
                        "BhAUEiwAf7wjkh_PUrypxfdhPo1_-3Bfh_pIEFk_VW-uXOoYp0xE6Mwce-sojqVj3BoCNYAQAvD_BwE"));
    }

    @Test
    public void testEnterWithInvalidСredentials() {
        page.getResponseWithInvalidCreds().assertThat()
                .statusCode(500)
                .header("Content-Length", equalTo("67998"))
                .header("content-type", equalTo("text/html"));
    }

    @Test
    public void testEnterWithIncorrectFormEmail(){
        page.getResponseWithIncorrectFormEmail().assertThat()
                .statusCode(200);
    }


    @Test
    public void testEnterWithEmptyFields() {
        page.getResponseWithEmptyFields()
                .statusCode(200)
                .header("content-type", equalTo("application/json; charset=UTF-8"))
                .body("error", equalTo("Введите email"));
    }
}
