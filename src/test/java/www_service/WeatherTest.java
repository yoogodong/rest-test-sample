package www_service;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
// 发请求间隔需要大于3秒，否则拒绝服务
public class WeatherTest {
    @Test
    public void testWeahter() throws Exception {
        given().queryParam("city","北京")
                .when().get("http://www.sojson.com/open/api/weather/json.shtml")
                .prettyPrint();
    }
}
