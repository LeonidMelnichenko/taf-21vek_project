package by.itacademy.melnichenko.leonid.api.requests;

import java.util.HashMap;

public class Request {
    public HashMap<String, String> getLoginHeaders(){
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Content-Type", "application/json");
        loginHeaders.put("x-requested-with", "XMLHttpRequest");
        return loginHeaders;
    }
    public HashMap<String, String> getSearchParams(){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("sa", "");
        searchParams.put("term", "adidas");

    }

}
