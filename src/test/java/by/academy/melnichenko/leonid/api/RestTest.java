package by.academy.melnichenko.leonid.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {
    @Test
    public void testEnterWithCorrectEmailAndPassword() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"test@test.com\",\n" +
                "        \"password\": \"1q2w3e4r\"\n" +
                "    }\n" +
                "}";
        given().when().header("Content-Type", "application/json").body(body).post("https://www.21vek.by/users/login/").then().log().body();
    }



}
