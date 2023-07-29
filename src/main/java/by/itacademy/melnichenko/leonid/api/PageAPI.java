package by.itacademy.melnichenko.leonid.api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PageAPI {
    private String endPointLoginForm = "https://www.21vek.by/users/action/login/";
    private String subjectToSearch = "https://www.21vek.by/tv/";
    private String endPointSearch = "https://www.21vek.by/search/";
    UserAPI userAPI = new UserAPI();

//    private HashMap<String, String> getLoginHeaders(String key, String value){
//        LinkedHashMap<String, String> loginHeaders = new LinkedHashMap;
//        loginHeaders.put(key, value);
//        return loginHeaders;
//    }

    public HashMap<String, String> getLoginHeadersToValidCredentials() {
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Content-Type", "application/json");
        loginHeaders.put("Referer", "https://www.21vek.by/?utm_source=google&utm_medium=cpc&utm_campaign=336837170&utm_" +
                "content=20888055050|596687804571&utm_term=21%20vek&gclid=CjwKCAjwzo2mBhAUEiwAf7wjkh_PUrypxfdhPo1_-3Bfh_" +
                "pIEFk_VW-uXOoYp0xE6Mwce-sojqVj3BoCNYAQAvD_BwE");
        loginHeaders.put("x-requested-with", "XMLHttpRequest");
        return loginHeaders;
    }
    public HashMap<String, String> getLoginHeadersToInvalidCredentials() {
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Host", "www.21vek.by");
        return loginHeaders;
    }

    public HashMap<String, String> getLoginHeadersToIncorrectFormEmail() {
        HashMap<String, String> loginHeaders = new HashMap<>();
//        loginHeaders.put("Content-Length", "<calculated when request is sent>");
//        loginHeaders.put("Host", "<calculated when request is sent>");
        loginHeaders.put("Content-Type", "application/json");
        return loginHeaders;
    }

    public HashMap<String, String> getLoginHeadersToEmptyFields() {
        HashMap<String, String> loginHeaders = new HashMap<>();
//        loginHeaders.put("Host", "<calculated when request is sent>");
        loginHeaders.put("x-requested-with", "XMLHttpRequest");
        return loginHeaders;
    }

    public ValidatableResponse getResponseWithValidCreds() {
        return given().when().headers(getLoginHeadersToValidCredentials())
                .body(userAPI.getValidCredentials())
                .post(endPointLoginForm)
                .then();
    }

    public ValidatableResponse getResponseWithInvalidCreds() {
        return given().when().headers(getLoginHeadersToInvalidCredentials())
                .body(userAPI.getInvalidCredentials())
                .post(endPointLoginForm)
                .then();
    }
    public ValidatableResponse getResponseWithIncorrectFormEmail() {
        return given().when().headers(getLoginHeadersToIncorrectFormEmail())
                .body(userAPI.getInvalidCredentials())
                .post(endPointLoginForm)
                .then().log().all();
    }

    public ValidatableResponse getResponseWithEmptyFields() {
        return given().when().headers(getLoginHeadersToEmptyFields())
                .body(userAPI.getEmptyFields())
                .post(endPointLoginForm)
                .then().log().all();
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
                .get(endPointSearch).then();
    }
}
