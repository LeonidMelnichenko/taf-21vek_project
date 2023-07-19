package by.itacademy.melnichenko.leonid.api.requests;

import java.util.HashMap;

public class Request {
    public HashMap<String, String> getLoginParams(){
        HashMap<String, String> loginParams = new HashMap<>();
        loginParams.put("", "");
        loginParams.put("", "");
        return loginParams;
    }
    public HashMap<String, String> getSearchParams(){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("sa", "");
        searchParams.put("term", "adidas");

    }

}
