package by.itacademy.melnichenko.leonid.api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PageAPI {
    private String urlLoginForm = "https://www.21vek.by/users/login/";
    private String subjectToSearch = "https://www.21vek.by/tv/";
    private String invalidValuesToSearch = "https://www.21vek.by/search/?sa=&term=%40%23%24%25%25%25%25%25%25";
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
    public HashMap<String, String> getSearchHeaders(){
        HashMap<String, String> searchHeaders = new HashMap<>();
        searchHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like " +
                "Gecko) Chrome/109.0.0.0 Safari/537.36");
        return searchHeaders;
    }
    public String getSearchParams(){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("sa", "");
        searchParams.put("term", "%40%23%24%25%25%25%25%25%25");
        return String.valueOf(searchParams);
    }
    public ValidatableResponse getSearchSomething(){
        return given().when().headers(getSearchHeaders())
                .get(subjectToSearch).then();
    }

    public ValidatableResponse getSearchWithInvalidValues(){
        return given().when().queryParam(getSearchParams()).headers(getSearchHeaders())
                .get(invalidValuesToSearch).then();
    }
}
