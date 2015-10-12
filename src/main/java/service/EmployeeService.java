package service;

import exception.DuplicateIdException;
import vo.Employee;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
@Path("employee")
@Produces("application/json")
@Singleton
public class EmployeeService {
    private static AtomicLong count = new AtomicLong(0);
    private Map<String,Employee> employeeMap= new HashMap<String,Employee>();

    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @POST
    public String add(@FormParam("name")String name,@FormParam("salary")Integer salary){
        String id = String.valueOf(count.addAndGet(1L));
        employeeMap.put(id,new Employee(id,name,salary));
        return id;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(Employee employee) throws DuplicateIdException {
        employeeMap.put(employee.getId(), employee);
        return employee.getId();
    }


    @GET
    @Path("{id}")
    public Employee get(@PathParam("id")String id){
        return employeeMap.get(id);
    }


    @DELETE
    public Employee delete(@QueryParam("id")String id){
       return employeeMap.remove(id);
    }

    @GET
    public Collection<Employee> get(){
        return employeeMap.values();
    }


}
