package service;

import com.jayway.restassured.http.ContentType;
import common.BaseIT;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

/**
 * integration
 * Created by Yonggao.Dong on 15/10/08.
 * 这里继承 BaseIT 是为了在 eclipse 中运行单个测试方法时，可以先执行BaseIT的 BeforeSuite
 */
public class EmployeeServiceIT extends BaseIT{

    private String id;
    private String name="Alex";
    private int salary=999;


    @Test
    public void should_return_digital_id_after_post_a_employee(){
        id = given().formParam("name",name).formParam("salary",salary).
//        		log().all().
        		when().post("employee").
                then().
//                log().all().
                statusCode(200).contentType(ContentType.JSON).
                extract().body().asString();

        assertTrue(id.matches("\\d+"),"the returned id  must be digital");
    }


    @Test(dependsOnMethods = "should_return_digital_id_after_post_a_employee")
    public void should_get_the_same_value_after_post(){
        get("employee/{id}",id).
                then().statusCode(200).contentType(ContentType.JSON).body("name",equalTo("Alex"),"salary",equalTo(999));
    }


    @Test(dependsOnMethods = "should_get_the_same_value_after_post")
    public void should_be_able_to_delete(){
        given().param("id",id).delete("employee").then().statusCode(200);
    }

    @Test(dependsOnMethods = "should_be_able_to_delete")
    public void should_not_be_able_to_get_after_delete(){
        get("employee/{id}",id).then().statusCode(204);
    }


}