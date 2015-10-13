package service;

import vo.Department;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
@Path("department")
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentService {

//    just for show test case
    private Department department;

    public DepartmentService() {
        department = new Department();
        department.setName("administrative");

        EmployeeService es = new EmployeeService();

        es.add("John",868);
        es.add("Marry",999);
        es.add("Nancy",1000);

        department.getEmployeeList().addAll(es.get());
    }

    @GET
    public Department get(){
        return department;
    }
}
