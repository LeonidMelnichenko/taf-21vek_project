package by.itacademy.melnichenko.leonid.api;

import java.util.Objects;

public class PostObject {
    private int id;
    private int userId;
    private String title;
    private String body;

    public PostObject(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "PostObject{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostObject that = (PostObject) o;
        return id == that.id && userId == that.userId && Objects.equals(title, that.title) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, body);
    }
}
