package www_service;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class Kuaidi100Test {
    @Test
    public void show_how_to_get_express_info() throws Exception {
        final ResponseBody body = given()
                .when().get("http://www.kuaidi100.com/query?type=emsguoji&postid=1003030947526&temp=0.04622020101317803")
                .body();
        final Object[] objects = body.jsonPath().getList("data", Map.class).stream().map(item -> item.get("context")).toArray();

        Arrays.stream(objects).forEach(item -> System.out.println(item));


    }
}
