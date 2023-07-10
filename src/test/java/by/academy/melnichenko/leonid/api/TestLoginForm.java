package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.Headers;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestLoginForm {
    private String urlLoginForm = "https://www.21vek.by/users/login/";
    Headers headers = new Headers();
    @Test
    public void testEnterWithValidСredentials() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"majorpayne748@gmail.com\",\n" +
                "        \"password\": \"TzSJ-e@C4YUqniM\"\n" +
                "    }\n" +
                "}";
        ValidatableResponse response = given().when().headers(headers.getHeaders()).body(body)
                .post(urlLoginForm).then();
        String expectedResult = "majorpayne748@gmail.com";
        Assert.assertEquals(response.extract().asString().contains("majorpayne748@gmail.com"), expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
    }
    @Test
    public void testEnterWithValidСredentialsSecondVariant() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"majorpayne748@gmail.com\",\n" +
                "        \"password\": \"TzSJ-e@C4YUqniM\"\n" +
                "    }\n" +
                "}";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("Content-Length", "<calculated when request is sent>");
        queryParams.put("Host", "<calculated when request is sent>");
        queryParams.put("Content-Type", "application/json");
        queryParams.put("x-requested-with", "XMLHttpRequest");
        given().when().queryParams(queryParams).body(body).post(urlLoginForm).then().log().body();
    }
    @Test
    public void testEnterWithCorrectEmailAndAnyPassword() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"test@test.com\",\n" +
                "        \"password\": \"1q2w3e4r\"\n" +
                "    }\n" +
                "}";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("Content-Length", "<calculated when request is sent>");
        queryParams.put("Host", "<calculated when request is sent>");
        queryParams.put("Content-Type", "application/json");
        given().when().queryParams(queryParams).body(body).post(urlLoginForm).then().log().body();
    }
    @Test
    public void enterWithEmptyFields(){
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"\",\n" +
                "        \"password\": \"\"\n" +
                "    }\n" +
                "}";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("Host", "<calculated when request is sent>");
        queryParams.put("x-requested-with", "XMLHttpRequest");
        given().when().queryParams(queryParams).body(body).post(urlLoginForm).then().log().body();
    }
    @Test
    public void enterWithIncorrectEmailAndAnyPassword(){
        String body = "{\"User\": {\"email\": \"qwertyuiop\",\"password\": \"123456789\"}}";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("Content-Length", "<calculated when request is sent>");
        queryParams.put("Host", "<calculated when request is sent>");
        queryParams.put("Content-Type", "application/json");
        given().when().queryParams(queryParams).body(body).post(urlLoginForm).then().log().body();
    }
    @Test
    public void enterWithEmptyEmailAndAnyPassword(){
        String body = "{\"User\":{\"email\":\"\",\"password\":\"123456789\"}}";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("Host", "<calculated when request is sent>");
        queryParams.put("x-requested-with", "XMLHttpRequest");
        given().when().queryParams(queryParams).body(body).post(urlLoginForm).then().log().body();
    }
    @Test
    public void enterWithCorrectEmailAndEmptyPassword(){
        String body = "{\"User\":{\"email\":\"test@test.com\",\"password\":\"\"}}";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("Content-Length", "<calculated when request is sent>");
        queryParams.put("Host", "<calculated when request is sent>");
        queryParams.put("Content-Type", "application/json");
        queryParams.put("x-requested-with", "XMLHttpRequest");
        given().when().queryParams(queryParams).body(body).post(urlLoginForm).then().log().body();
    }
}
