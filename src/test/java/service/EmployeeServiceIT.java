package service;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

/**
 * integration
 * Created by Yonggao.Dong on 15/10/08.
 */
@Test
public class EmployeeServiceIT {

    @BeforeClass
    public void config(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath="rest-test/employee";
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
    }
    

    



    public void should_get_the_same_employee_and_be_deleteable_after_add(){
        String id = given().formParameters("name","Alex","salary",999).
                when().post().body().asString();

//        We can imply it like this :
//          assertEquals(get(id).statusCode(),200);
//        String em1=get(id).body().asString();
//        String expect = "{"id":1,"name","Alex","salary":999,a:{b:c}}";  body("a.b",c)
//
//        assertEquals(em1,expect);

        get(id).then().log().all().statusCode(200).body("id", equalTo(id)).body("name",equalTo("Alex"),"salary",equalTo(999));

        given().param("id",id).
                when().delete().
                then().statusCode(200).body("id", equalTo(id)).body("name", equalTo("Alex")).body("salary", equalTo(999));
    }

    //just show how to re-use response specification;
    public void should_get_the_same_employee_and_be_deleteable_after_add2(){

        String id = given().formParameters("name", "国家", "salary", 999).
                log().all().
                when().post().body().asString();
        ResponseSpecification spec=expect().statusCode(200).body("id", equalTo(id)).body("name", equalTo("国家")).body("salary", equalTo(999));

        get(id).then().spec(spec);
        given().param("id", id).
                when().delete().then().spec(spec);
    }



    public void should_not_get_the_employee_that_has_been_deleted(){
        String id = given().formParameters("name","Alex","salary",999).
                when().post().body().asString();
        given().param("id", id).
                when().delete();
        int bodyLength = get(id).then().extract().asString().length();
        assertEquals(bodyLength,0);
    }

    public void should_not_get_the_employee_that_has_been_deleted2(){
        String id = given().formParameters("name","Alex","salary",999).
                when().post().body().asString();
        given().param("id", id).
                when().delete();
        get(id).then().statusCode(204);
    }



}