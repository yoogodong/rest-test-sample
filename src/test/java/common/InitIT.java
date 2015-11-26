package common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeSuite;

import static com.jayway.restassured.config.EncoderConfig.encoderConfig;

/**
 * Created by Yonggao.Dong on 15/11/26.
 */
public class InitIT {

    @BeforeSuite
    public void init(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath="rest-test";
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
    }
}
