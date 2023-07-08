package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PostObject;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class RestTest {
    private String urlLoginForm = "https://www.21vek.by/users/login/";
    private String headerName = "Content-Type";
    private String headerValue = "application/json";

    @Test
    public void testEnterWithValidСredentials() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"majorpayne748@gmail.com\",\n" +
                "        \"password\": \"TzSJ-e@C4YUqniM\"\n" +
                "    }\n" +
                "}";
        ValidatableResponse response = given().when().header(headerName, headerValue).body(body)
                .post(urlLoginForm).then().log().body();
//        String expectedResult = "majorpayne748@gmail.com";
//        String actualResult = response.extract().asPrettyString();
//        Assert.assertEquals(actualResult, expectedResult);
//        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test
    public void testEnterWithCorrectEmailAndAnyPassword() {
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"test@test.com\",\n" +
                "        \"password\": \"1q2w3e4r\"\n" +
                "    }\n" +
                "}";
        ValidatableResponse response = given().when().header(headerName, headerValue).body(body)
                .post(urlLoginForm).then();
        String expectedResult = "{\n" +
                "    \"error\": \"Неправильный пароль\"\n" +
                "}";
        String actualResult = response.extract().asPrettyString();
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test
    public void enterWithEmptyFields(){
        String body = "{\n" +
                "    \"User\": {\n" +
                "        \"email\": \"\",\n" +
                "        \"password\": \"\"\n" +
                "    }\n" +
                "}";
        ValidatableResponse response = given().when().header(headerName, headerValue).body(body)
                .post(urlLoginForm).then();
        String expectedResult = "{\n" +
                "    \"error\": \"Введите email\"\n" +
                "}";
        String actualResult = response.extract().asPrettyString();
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test
    public void enterWithIncorrectEmailAndAnyPassword(){
        String body = "{\"User\": {\"email\": \"qwertyuiop\",\"password\": \"123456789\"}}";
        ValidatableResponse response = given().when().header(headerName, headerValue).body(body)
                .post(urlLoginForm).then();
        String actualResult = response.extract().asPrettyString();
        String expectedResult = "{\n" +
                "    \"error\": \"Ошибка валидации поля email\"\n" +
                "}";
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
    }
    @Test
    public void enterWithEmptyEmailAndAnyPassword(){
        String body = "{\"User\":{\"email\":\"\",\"password\":\"123456789\"}}";
        ValidatableResponse response = given().when().header(headerName, headerValue).body(body)
                .post(urlLoginForm).then();
        String actualResult = response.extract().asPrettyString();
        String expectedResult = "{\n" +
                "    \"error\": \"Введите email\"\n" +
                "}";
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
    }
    @Test
    public void enterWithCorrectEmailAndEmptyPassword(){
        String body = "{\"User\":{\"email\":\"test@test.com\",\"password\":\"\"}}";
        ValidatableResponse response = given().when().header(headerName, headerValue).body(body)
                .post(urlLoginForm).then();
        String actualResult = response.extract().asPrettyString();
        String expectedResult = "{\n" +
                "    \"error\": \"Неправильный пароль\"\n" +
                "}";
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
    }


//    @Test
//    public void testEnterWithValid() {
//        PostObject po = new PostObject("majorpayne748@gmail.com", "TzSJ-e@C4YUqniM");
//        ValidatableResponse response = given().when().header(headerName, headerValue).body(po).
//                post(urlLoginForm).then().assertThat().body(containsString("majorpayne748@gmail.com"));
//        String actualResult = response.extract().asString();
//        String expectedResult = "majorpayne748@gmail.com";
//        Assert.assertTrue(true, "200");
//    }

    @Test
    public void testWithCorrectFields(){
        PostObject po = new PostObject("test@test.com", "1234567");
        given().when().header("Content-Type", "application/json").body(po).
                post("https://www.21vek.by/users/login/").
                then().
                assertThat().
                statusCode(200);


        String expectedResult = "Неправильный пароль.";
        String actualResuilt = "Неправильный пароль";
        Assert.assertEquals(actualResuilt, expectedResult);
    }

    @Test
    public void testGetSearchAdidas() {
        String expectedResult = "adidas";
        ValidatableResponse response = given().when().get("https://www.21vek.by/search/?sa=&term=adidas&searchId" +
                        "=3572cc961d1e4cf6a5a477b08de38b91").then();
        String actualBody = response.extract().asString();
        Assert.assertTrue(actualBody.contains(expectedResult));
        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test
    public void testGetSearchPhone(){
        String expectedResult = "Samsung Galaxy S22 Ultra";
        ValidatableResponse response = given().when().get("https://www.21vek.by/mobile/" +
                        "galaxys22ultra12gb512gbsms908bzahser_samsung.html").then();
        String actualBody = response.extract().asString();
        Assert.assertTrue(actualBody.contains(expectedResult));
        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test
    public void testGetSearchWithInvalidData(){
        String expectedResult = "@###!!!!$$$$";
        ValidatableResponse response = given().when().get("https://www.21vek.by/search/?sa=&term" +
                "=@%23%23%23!!!!$$$$&searchId=d2bb5020fa1c4082ab5534d7cac70138").then();
        String actualResult = response.extract().asString();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test
    public void testGetSearchNonExistentGoods(){
        String expectedBody = "land of pink elephants";
        ValidatableResponse response = given().when().get("https://www.21vek.by/search/?sa=&term" +
                "=land%20of%20pink%20elephants&searchId=72f9cacd6f9647828ac5957d304e51b3").then();
        String actualResult = response.extract().asString();
        Document document = Jsoup.parse(actualResult);
        Elements element = document.getElementsByTag("style");
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(element.contains(expectedBody));

    }
}
