package by.itacademy.melnichenko.leonid.api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PageAPI {
    private String urlLoginForm = "https://www.21vek.by/users/login/";
    UserAPI userAPI = new UserAPI();

    public HashMap<String, String> getLoginHeadersToCredentials() {
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Content-Type", "application/json");
        return loginHeaders;
    }

    public HashMap<String, String> getLoginHeadersToEmptyFields() {
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Host", "<calculated when request is sent>");
        return loginHeaders;
    }

    public ValidatableResponse getResponseValidCreds() {
        return given().when().headers(getLoginHeadersToCredentials())
                .body(userAPI.getValidСredentials())
                .post(urlLoginForm)
                .then();
    }

    public ValidatableResponse getResponseInvalidCreds() {
        return given().when().headers(getLoginHeadersToCredentials())
                .body(userAPI.getInvalidСredentials())
                .post(urlLoginForm)
                .then();
    }

    public ValidatableResponse getResponseWithEmptyFields() {
        return given().when().headers(getLoginHeadersToEmptyFields())
                .body(userAPI.getEmptyFields())
                .post(urlLoginForm)
                .then();
    }
}
