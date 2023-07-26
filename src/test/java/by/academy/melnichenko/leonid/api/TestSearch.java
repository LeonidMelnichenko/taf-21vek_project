package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PageAPI;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch {

    PageAPI page = new PageAPI();

    @Test
    public void testSearchTV() {
        ValidatableResponse response = page.getSearchSomething();
        System.out.println(response);
        response.assertThat().statusCode(200);
        String title = Jsoup.parse(response.extract().asString()).body().getElementsByTag("h1").get(0).text();
        Assert.assertEquals(title, "Результаты поиска");
    }
}
