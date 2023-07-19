package by.itacademy.melnichenko.leonid.api.requests;

import java.util.HashMap;

public class Request {
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
}
