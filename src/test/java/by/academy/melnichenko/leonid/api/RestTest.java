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

import java.util.HashMap;

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
        String headersString = "Accept:application/json;version=1.1\n" +
                "Accept-Language:ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7\n" +
                "Connection:keep-alive\n" +
                "Content-Type:application/json\n" +
                "Cookie:Settings[ft_split_group]=666; Settings[userCity_]=Q3FrZQ%3D%3D.F0QCA2YACwQBGEZYR15LE1tAR1UCBQ5FfhgZFxoKFgERC0tNEG9GBFhVWElkZlwFAhkWNBBCXUQKb0YEWFUPOzEKHQEHdABYUUEIVU8%3D; sbjs_migrations=1418474375998%3D1; sbjs_first_add=fd%3D2023-06-21%2022%3A27%3A13%7C%7C%7Cep%3Dhttps%3A%2F%2Fwww.21vek.by%2F%3Futm_source%3Dadmitad%26utm_medium%3Dbanners%26utm_campaign%3Done%26utm_content%3D1370750%26tagtag_uid%3Daadbaecf8a8cc3f9e4e994cf29078332%7C%7C%7Crf%3Dhttps%3A%2F%2Fblogs.digitalgenics.co%2F; sbjs_first=typ%3Dutm%7C%7C%7Csrc%3Dadmitad%7C%7C%7Cmdm%3Dbanners%7C%7C%7Ccmp%3Done%7C%7C%7Ccnt%3D1370750%7C%7C%7Ctrm%3D%28none%29; _slid=64934f1e11454d26ed0c1202; _gcl_au=1.1.1790378934.1687375646; mindboxDeviceUUID=da584fc4-5e8f-4d65-ab9c-d9742b6d272d; directCrm-session=%7B%22deviceGuid%22%3A%22da584fc4-5e8f-4d65-ab9c-d9742b6d272d%22%7D; _rid=05abef431963451583ed7d24774d5c47; _rid_anm_id=05abef431963451583ed7d24774d5c47; tmr_lvid=ef99595aacca3f9996864bae652dd49c; tmr_lvidTS=1687375646590; _fbp=fb.1.1687375646889.1228102680; popmechanic_sbjs_migrations=popmechanic_1418474375998%3D1%7C%7C%7C1471519752600%3D1%7C%7C%7C1471519752605%3D1; _tt_enable_cookie=1; _ttp=38hpMCDbxUAKU1ZYYgTILFP71yP; _ym_uid=1687375647249863934; _ym_d=1687375647; clickanalyticsresource=e951ad1e-3c0a-42fc-be82-6224edf410a7; blueID=d7754416-beb0-48aa-a9c1-92ad6318f400; tagtag_aid=32ba9fc0e8dfef7f6625e02b7022e27c; tagtag_aid=32ba9fc0e8dfef7f6625e02b7022e27c; tagtag_aid=32ba9fc0e8dfef7f6625e02b7022e27c; Settings[partner]=%7B%22name%22%3A%22google%22%7D; tt_deduplication_cookie=google; tt_deduplication_cookie=google; tt_deduplication_cookie=google; blueULC=google; _ga_HWRWZM3ZEW=GS1.1.1688390287.4.0.1688390307.40.0.0; ajs_user_id=%2213990280%22; new_user=1; gnezdo_uid=XV9n6WRoqd0YT+79Up2TAg==; 21vek=1d431f0e-ec3b-4093-a993-435feb2f289b; accessToken=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjAxOTY2OTksInN1YiI6IjFkNDMxZjBlLWVjM2ItNDA5My1hOTkzLTQzNWZlYjJmMjg5YiIsImlhdCI6MTY4ODY0OTg5OSwiYW5vIjoxLCJ2ZXIiOjAuMX0.RfMdYNhkpQRaeHWoEQPtyfsI0qHGrKOM9TRtyfxAO7M; refreshToken=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjAxOTY2OTksImlhdCI6MTY4ODY0OTg5OSwianRpIjoiMWQ0MzFmMGUtZWMzYi00MDkzLWE5OTMtNDM1ZmViMmYyODliIiwiYW5vIjoxLCJ2ZXIiOjAuMX0._WuE839x8D0I3PLWh6-_BtW8GDGENqHPFOMFrusxu84; _ym_isad=2; _gid=GA1.2.850154499.1688753145; Settings[detectum_filter]=Q3FrZQ%3D%3D.F0QfAjZXCw8URBQGAVIGERJDWloHRg4LIUpBVFhcBkpJUAoWRlZUWx4fNA4gGBMXBRxEXEdeSxhAV1ZGMwQSRX5UXFlaBFcbBFBTVRBO; sbjs_current_add=fd%3D2023-07-08%2010%3A24%3A30%7C%7C%7Cep%3Dhttps%3A%2F%2Fwww.21vek.by%2F%3Futm_source%3Dgoogle%26utm_medium%3Dcpc%26utm_campaign%3D336837170%26utm_content%3D20888055050%7C596687804571%26utm_term%3D21%2520vek%26gclid%3DCj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB%7C%7C%7Crf%3Dhttps%3A%2F%2Fwww.google.com%2F; sbjs_current=typ%3Dutm%7C%7C%7Csrc%3Dgoogle%7C%7C%7Cmdm%3Dcpc%7C%7C%7Ccmp%3D336837170%7C%7C%7Ccnt%3D20888055050%7C596687804571%7C%7C%7Ctrm%3D21%2520vek; sbjs_udata=vst%3D22%7C%7C%7Cuip%3D%28none%29%7C%7C%7Cuag%3DMozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F114.0.0.0%20Safari%2F537.36; _ttgclid=Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; _ttgclid=Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; _ttgclid=Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; _gcl_aw=GCL.1688801071.Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; _gac_UA-32484123-1=1.1688809420.Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; Settings[u_source]=Q3FrZQ%3D%3D.BBIfFzcABhpBXwJGV0MfElkdUU0%3D; _slsession=30708FBE-99A9-40F4-9241-13E62AE8E019; _ga=GA1.2.1289932383.1687375647; _ym_visorc=b; _ga_KBL22GMK8D=GS1.1.1688815435.31.0.1688815437.58.0.0; tmr_detect=0%7C1688815438235\n" +
                "Origin:https://www.21vek.by\n" +
                "Referer:https://www.21vek.by/?utm_source=google&utm_medium=cpc&utm_campaign=336837170&utm_content=20888055050|596687804571&utm_term=21%20vek&gclid=Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB\n" +
                "Sec-Fetch-Dest:empty\n" +
                "Sec-Fetch-Mode:cors\n" +
                "Sec-Fetch-Site:same-origin\n" +
                "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36\n" +
                "cache-control:no-cache\n" +
                "pragma:no-cache\n" +
                "sec-ch-ua:\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"\n" +
                "sec-ch-ua-mobile:?0\n" +
                "sec-ch-ua-platform:\"Windows\"\n" +
                "traceparent:00-31d3da8545d7fc01b9380e7b1a208c77-19a7e2dc022e042b-01\n" +
                "x-requested-with:XMLHttpRequest";
        String[] pairs = headersString.split("\n");
        HashMap<String, String> headersMap = new HashMap<>();
        for (String string : pairs){
            String[] keyValue = string.split(":");
            headersMap.put(keyValue[0], keyValue[1]);
        }
        ValidatableResponse response = given().when().headers(headersMap).body(body)
                .post(urlLoginForm).then().log().body();
        response.extract().statusCode();
        String expectedResult = "majorpayne748@gmail.com";
        String actualResult = response.extract().asPrettyString();
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(response.extract().statusCode(), 200);
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
