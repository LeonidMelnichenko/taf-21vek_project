package by.itacademy.melnichenko.leonid.api;

import java.util.HashMap;

public class UserAPI {
    public String email;
    public String password;

    public HashMap<String, Object> getValidСredentials() {
        UserAPI userAPI = new UserAPI();
        userAPI.email = "majorpayne748@gmail.com";
        userAPI.password = "TzSJ-e@C4YUqniM";
        HashMap<String, Object> validСredentials = new HashMap<>();
        validСredentials.put("User", userAPI);
        return validСredentials;
    }

    public HashMap<String, Object> getInvalidСredentials() {
        UserAPI userAPI = new UserAPI();
        userAPI.email = "qwerty@gmail.com";
        userAPI.password = "12321312312312";
        HashMap<String, Object> validСredentials = new HashMap<>();
        validСredentials.put("User", userAPI);
        return validСredentials;
    }

    public HashMap<String, Object> getEmptyFields() {
        UserAPI userAPI = new UserAPI();
        userAPI.email = "";
        userAPI.password = "";
        HashMap<String, Object> validСredentials = new HashMap<>();
        validСredentials.put("User", userAPI);
        return validСredentials;
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
