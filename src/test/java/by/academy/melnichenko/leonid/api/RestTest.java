package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PostObject;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {
    @Test
    public void testEnterWithCorrectEmailAndPassword() {
        String body = "{\"User\":{\"email\":\"test@test.com\",\"password\":\"423424422352\"}}";
        ValidatableResponse response = given().when().header("Content-Type", "application/json").body(body).
                post("https://www.21vek.by/users/login/").then().log().body();
//        Assert.assertEquals(response, expected);
    }
    }
