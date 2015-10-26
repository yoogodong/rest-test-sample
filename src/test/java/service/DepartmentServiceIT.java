package service;

import com.jayway.restassured.RestAssured;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vo.Department;
import vo.Employee;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
public class DepartmentServiceIT {

    @BeforeClass
    public void config(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath="rest-test/department";
    }

    @Test
    public void should_exists_employee_whose_salary_is_1000(){
        Department dep = get().then().statusCode(200).extract().as(Department.class);

        assertThat(dep.getEmployeeList(),hasItem(new BaseMatcher<Employee>() {

            @Override
            public void describeTo(Description description) {

            }

            @Override
            public boolean matches(Object item) {
                Employee employee = (Employee) item;
                return employee.getSalary().equals(1000);
            }
        }));

    }

    @Test
    public void should_exists_employee_whose_salary_is_1000_with_json_path(){
        get().then().statusCode(200).body("employeeList.salary",hasItem(1000));
    }
}