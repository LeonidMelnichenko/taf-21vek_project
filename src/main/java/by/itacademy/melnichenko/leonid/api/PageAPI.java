package by.itacademy.melnichenko.leonid.api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PageAPI {
    private String urlLoginForm = "https://www.21vek.by/users/login/";
    private String subjectToSearch = "https://www.21vek.by/tv/";
    private String searchUrl = "https://www.21vek.by/search/";
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
    public HashMap<String, String> getSearchParams(){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("sa", "");
        searchParams.put("term", "Телевизоры");
        searchParams.put("searchIf", "bc99e2ba90424e9f99cf83b7c1665296");
        return searchParams;
    }
    public ValidatableResponse getSearchSomething(){
        return given().when().queryParams(getSearchParams()).headers(getSearchHeaders())
                .get(searchUrl).then();
    }
}
