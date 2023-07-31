package by.itacademy.melnichenko.leonid.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PageAPI {
    private String endPointLoginForm = "https://www.21vek.by/users/action/login/";
    private String endPointSearch = "https://www.21vek.by/search/";

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Content-Type", "application/json");
        loginHeaders.put("Host", "www.21vek.by");
        loginHeaders.put("x-requested-with", "XMLHttpRequest");
        return loginHeaders;
    }

    @Step("Send login request with data {0}")
    public ValidatableResponse getLoginResponse(HashMap<String, UserAPI> loginJSON) {
        return given().when().headers(getHeaders())
                .body(loginJSON)
                .post(endPointLoginForm)
                .then();
    }

    public HashMap<String, String> getSearchHeaders() {
        HashMap<String, String> searchHeaders = new HashMap<>();
        searchHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like " +
                "Gecko) Chrome/109.0.0.0 Safari/537.36");
        return searchHeaders;
    }

    public HashMap<String, String> getSearchParams() {
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("sa", "");
        searchParams.put("term", "Телевизоры");
        searchParams.put("searchIf", "bc99e2ba90424e9f99cf83b7c1665296");
        return searchParams;
    }

    @Step("Send request")
    public ValidatableResponse getSearchSomething() {
        return given().when().queryParams(getSearchParams()).headers(getSearchHeaders())
                .get(endPointSearch).then();
    }
}
