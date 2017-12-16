package myservice;

import app.utils.vo.Department;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
@Path("department")
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentService {

//    just for show test case
    private Department cachedDepartment;


    @GET
    @Path("{someone}")
    public Department get(@PathParam("someone") String someone){
        return loadSampleDepartment();
    }


    private Department loadSampleDepartment(){
        if (cachedDepartment == null) {
            cachedDepartment = new Department();
            cachedDepartment.setName("administrative");

            EmployeeService es = new EmployeeService();

            es.add("John", 868);
            es.add("Marry", 999);
            es.add("Nancy", 1000);
            cachedDepartment.getEmployeeList().addAll(es.get());
        }
        return cachedDepartment;
    }
}
