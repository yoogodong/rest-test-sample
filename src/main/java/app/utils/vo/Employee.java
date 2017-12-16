package app.utils.vo;

/**
 * Created by Yonggao.Dong on 15/10/08.
 */
public class Employee {
    private String id;
    private String name;
    private Integer salary;

    public Employee() {
    }

    public Employee(String id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
