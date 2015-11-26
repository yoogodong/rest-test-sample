package common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static com.jayway.restassured.config.EncoderConfig.encoderConfig;

/**
 * Created by Yonggao.Dong on 15/11/26.
 */
public class BaseIT {

    @BeforeSuite
    @Parameters({"baseURI","port","basePath"})
    public void init(String url,int port,String path){
        RestAssured.baseURI=url;
        RestAssured.port=port;
        RestAssured.basePath=path;
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
    }
}
