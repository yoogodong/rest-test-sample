package service;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
public class DepartmentServiceIT {


    @Test
    public void should_exists_employee_whose_salary_is_1000_with_json_path(){
        get("/department").then().statusCode(200).body("employeeList.salary",hasItem(1000));
    }
}