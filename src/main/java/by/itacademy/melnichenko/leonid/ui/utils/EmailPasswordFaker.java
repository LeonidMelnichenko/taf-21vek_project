package by.itacademy.melnichenko.leonid.ui.utils;

import com.github.javafaker.Faker;

public class EmailPasswordFaker {
    Faker faker;
    public EmailPasswordFaker(Faker faker) {
        this.faker = faker;
    }
    public String generateFakerEmail(){
        faker = new Faker();
        String fakerEmail = faker.internet().emailAddress();
        return fakerEmail;
    }
    public String genarateFakerPassword(){
        faker = new Faker();
        String fakerPassword = faker.internet().password();
        return fakerPassword;
    }
}
