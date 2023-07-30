package by.itacademy.melnichenko.leonid.api;

import java.util.HashMap;

public class UserAPI {
    public String email;
    public String password;

    public UserAPI(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private static HashMap<String, UserAPI> createCredentials(String email, String password) {
        UserAPI userAPI = new UserAPI(email, password);
        HashMap<String, UserAPI> validCredentials = new HashMap<>();
        validCredentials.put("User", userAPI);
        return validCredentials;
    }

    public static HashMap<String, UserAPI> getValidCredentials() {
        return createCredentials("majorpayne748@gmail.com", "TzSJ-e@C4YUqniM");
    }

    public static HashMap<String, UserAPI> getInvalidCredentials() {
        return createCredentials("test12345@test.com", "1q2w357567");
    }

    public static HashMap<String, UserAPI> getShortPasswordCredentials() {
        return createCredentials("test12345@test.com", "1q2w");
    }


    public static HashMap<String, UserAPI> getIncorrectFormEmailAndAnyPassword() {
        return createCredentials("test12345", "12345678");
    }

    public static HashMap<String, UserAPI> getEmptyFields() {
        return createCredentials("", "");
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

