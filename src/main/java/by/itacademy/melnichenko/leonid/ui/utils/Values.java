package by.itacademy.melnichenko.leonid.ui.utils;

public enum Values {
    NO_ACCOUNT ("Нет такого аккаунта. \nЗарегистрироваться?"),
    INVALID_FORMAT_EMAIL("Неправильный формат электронной почты"),
    EMPTY_EMAIL ("Электронная почта не указана"),
    EMPTY_PASSWORD ("Пароль не указан");
    private final String values;
    Values(String values) {
        this.values = values;
    }
    public String getValues() {
        return values;
    }
}
