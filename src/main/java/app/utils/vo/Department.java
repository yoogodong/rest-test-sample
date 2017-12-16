package app.utils.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
public class Department {
    private String name;
    private List<Employee> employeeList = new ArrayList<Employee>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


}
