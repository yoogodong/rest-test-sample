package service;

import common.BaseIT;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Yonggao.Dong on 15/10/08.
 * 这里继承 BaseIT 是为了在 eclipse 中运行单个测试方法时，可以先执行BaseIT的 BeforeSuite
 */
public class DepartmentServiceIT extends BaseIT{

    @Test
    public void should_exists_employee_whose_salary_is_1000_with_json_path(){
        get("/department").then().statusCode(200).body("employeeList.salary",hasItem(1000));
    }

}