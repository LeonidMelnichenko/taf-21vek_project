package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.Headers;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestLoginForm {
    private String urlLoginForm = "https://www.21vek.by/users/login/";
    @Test
    public void testEnterWithValidСredentials() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"majorpayne748@gmail.com\",\n" +
                "        \"password\": \"TzSJ-e@C4YUqniM\"\n" +
                "    }\n" +
                "}";
        given().when().header("Content-Type", "application/json").body(body).post(urlLoginForm)
                .then().assertThat()
                .statusCode(302)
                .header("content-type", equalTo("text/html; charset=UTF-8"))
                .header("location", equalTo("https://www.21vek.by/"));
    }
    @Test
    public void testEnterWithInalidСredentials() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"qwerty@gmail.com\",\n" +
                "        \"password\": \"12321312312312\"\n" +
                "    }\n" +
                "}";
        given().when().header("Content-Type", "application/json").body(body).post(urlLoginForm)
                .then()
                .assertThat()
                .statusCode(200)
                .header("content-type", equalTo("application/json"))
                .body("error", equalTo("Неправильный пароль"));
    }
    @Test
    public void testEnterWithEmptyFields() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"\",\n" +
                "        \"password\": \"\"\n" +
                "    }\n" +
                "}";
        given().when().header("Host", "<calculated when request is sent>").body(body).post(urlLoginForm)
                .then()
                .assertThat()
                .statusCode(404)
                .header("content-type", equalTo("text/html"));
    }
}
