package www_service;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class CalendarTest {
    @Test
    public void testCalendar() throws Exception {
        given().queryParam("date","2017-12-16")
                .when().get("http://www.sojson.com/open/api/lunar/json.shtml").prettyPrint();
    }
}
