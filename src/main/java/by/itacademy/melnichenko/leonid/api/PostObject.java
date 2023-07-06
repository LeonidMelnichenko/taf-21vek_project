package by.itacademy.melnichenko.leonid.api;

import java.util.Objects;

public class PostObject {
    private String email;
    private String password;

    public PostObject(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostObject{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostObject that)) return false;
        return email.equals(that.email) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}



