package by.academy.melnichenko.leonid.api;

import by.itacademy.melnichenko.leonid.api.PageAPI;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {

    PageAPI page = new PageAPI();

    @Test
    public void testSearchSomething() {
        ValidatableResponse response = page.getSearchSomething();
        response.assertThat().statusCode(200);
        String title = Jsoup.parse(response.extract().asString()).body().getElementsByTag("h1").get(0).text();
        Assert.assertEquals(title, "Результаты поиска");
    }
}
