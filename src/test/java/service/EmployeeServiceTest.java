package service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vo.Employee;

/**
 * Created by Yonggao.Dong on 15/11/5.
 */
public class EmployeeServiceTest {
    EmployeeService service ;

    @BeforeClass
    public void init(){
        service = new EmployeeService();
    }


    @Test
    public void testAdd() throws Exception {
        service.add("name",19);
    }

    @Test
    public void testAdd1() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        Employee em = service.get("1");
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGet1() throws Exception {

    }
}