package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PostObject;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {
    @Test
    public void testEnterWithCorrectEmailAndPassword() {
        String body = "{\"User\":{\"email\":\"test@test.com\",\"password\":\"423424422352\"}}";
        ValidatableResponse response = given().when().header("Content-Type", "application/json").body(body).
                post("https://www.21vek.by/users/login/").then().log().body();
//        Assert.assertEquals(response, expected);
    }
    @Test
    public void testGetSearhAdidas() {
        given()
                .when()
                .get("https://www.21vek.by/search/?sa=&term=adidas&searchId=3572cc961d1e4cf6a5a477b08de38b91")
                .then()
                .log()
                .body();
    }
    @Test
    public void testGetSearchAdidasAndPuma(){
        given()
                .when()
                .get("https://www.21vek.by/search/?sa=&term=addidas%20puma&searchId" +
                        "=5f107bb562a04c24ba77eb6fe6abd91c")
                .then()
                .log()
                .body();
    }
    @Test
    public void testGetSearchPhone(){
        given()
                .when()
                .get("https://www.21vek.by/mobile/galaxys22ultra12gb512gbsms908bzahser_samsung.html")
                .then()
                .log()
                .body();
    }

    @Test
    public void testGetSearchWithInvalidData(){
        given()
                .when()
                .get("https://www.21vek.by/search/?sa=&term=%40%40%23%23%23%23%23%23%23&searchId" +
                        "=d2bb5020fa1c4082ab5534d7cac70138")
                .then()
                .log()
                .body();
    }

    @Test
    public void testGetSearchNonExistentGoods(){
        given()
                .when()
                .get("https://www.21vek.by/search/?sa=&term" +
                        "=%D1%82%D0%B8%D0%BB%D0%B8%D0%BC%D0%B8%D1%82%D1%80%D1%8F%D0%BC%D0%B4%D0%B8%D1%8F&searchId" +
                        "=9b9c9bdd8e3e4cdaa904a3f1f67f1399")
                .then()
                .log()
                .body();
    }
}
