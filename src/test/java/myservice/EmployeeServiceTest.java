package myservice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import app.utils.vo.Employee;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by Yonggao.Dong on 15/11/5.
 */
public class EmployeeServiceTest {
    EmployeeService service ;
    String id;

    @BeforeClass
    public void init(){
        service = new EmployeeService();
    }


    @Test
    public void testAdd() throws Exception {
        id=service.add("翠花",19);
        assertNotNull(id);
    }


    @Test
    public void testGet() throws Exception {
        Employee em = service.get(id);
        assertEquals(em.getName(),"翠花");
    }

}