package by.itacademy.melnichenko.leonid.api;

import java.util.HashMap;

public class UserAPI {
    public String email;
    public String password;

    public UserAPI(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserAPI() {
    }

    private HashMap<String, Object> createCredentials(String email, String password) {
        UserAPI userAPI = new UserAPI(email, password);
        HashMap<String, Object> validCredentials = new HashMap<>();
        validCredentials.put("User", userAPI);
        return validCredentials;
    }

    public HashMap<String, Object> getValidCredentials() {
        return createCredentials("majorpayne748@gmail.com", "TzSJ-e@C4YUqniM");
    }

    public HashMap<String, Object> getInvalidCredentials() {
        return createCredentials("test12345@test.com", "1q2w3");
    }

    public HashMap<String, Object> getIncorrectFormEmailAndAnyPassword() {
        return createCredentials("test12345", "1233");
    }

    public HashMap<String, Object> getEmptyFields() {
        return createCredentials("", "");
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
