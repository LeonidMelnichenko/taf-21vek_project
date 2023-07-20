package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PageAPI;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestSearch {

    PageAPI page = new PageAPI();

    @Test
    public void testSearchTV() {
        page.getSearchSomething()
                .assertThat().statusCode(200)
                .header("content-type", equalTo("text/html; charset=UTF-8"));
    }

    @Test
    public void testSearchWithInvalidValues() {
        page.getSearchWithInvalidValues()
                .assertThat().statusCode(200)
                .header("content-type", equalTo("text/html; charset=UTF-8"));
    }
}


//        String actualResult = response.extract().asString();
//        Document document = Jsoup.parse(actualResult);
//        Elements element = document.getElementsByTag("style");
//        System.out.println(actualResult);
//        Assert.assertEquals().body()
//        Assert.assertEquals(response.extract().statusCode(), 200);
//        Assert.assertEquals(actualResult, element.contains(expectedResult));
//        Assert.assertEquals(actualBody.contains(expectedResult));
//    }
//    @Test
//    public void testGetSearchPhone(){
//        String expectedResult = "Samsung Galaxy S22 Ultra";
//        ValidatableResponse response = given().when().get("https://www.21vek.by/mobile/" +
//                "galaxys22ultra12gb512gbsms908bzahser_samsung.html").then();
//        String actualBody = response.extract().asString();
//        Assert.assertTrue(actualBody.contains(expectedResult));
//        Assert.assertEquals(response.extract().statusCode(), 200);
//    }
//    @Test
//    public void testGetSearchWithInvalidData(){
//        String expectedResult = "@###!!!!$$$$";
//        ValidatableResponse response = given().when().get("https://www.21vek.by/search/?sa=&term" +
//                "=@%23%23%23!!!!$$$$&searchId=d2bb5020fa1c4082ab5534d7cac70138").then();
//        String actualResult = response.extract().asString();
//        Assert.assertTrue(actualResult.contains(expectedResult));
//        Assert.assertEquals(response.extract().statusCode(), 200);
//    }
//    @Test
//    public void testGetSearchNonExistentGoods(){
//        String expectedBody = "land of pink elephants";
//        ValidatableResponse response = given().when().get("https://www.21vek.by/search/?sa=&term" +
//                "=land%20of%20pink%20elephants&searchId=72f9cacd6f9647828ac5957d304e51b3").then();
//        String actualResult = response.extract().asString();
//        Document document = Jsoup.parse(actualResult);
//        Elements element = document.getElementsByTag("style");
//        Assert.assertEquals(response.extract().statusCode(), 200);
//        Assert.assertEquals(actualResult, element.contains(expectedBody));
//    }
