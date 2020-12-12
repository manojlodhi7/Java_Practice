import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class Employee{
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    private boolean married;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean getMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }

}

public class RestAssured_POJO {

    public void getPojoFromEmployeeObject() throws IOException {
        // Just create an object of Pojo class
        Employee employee = new Employee();
        employee.setFirstName("Amod");
        employee.setLastName("Mahajan");
        employee.setAge(29);
        employee.setGender("Male");
        employee.setSalary(3434343);
        employee.setMarried(false);

        // Converting a Java class object to a JSON payload as string
        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

        // Converting EMployee json string to Employee class object
        Employee employee2 = objectMapper.readValue(employeeJson, Employee.class);
        System.out.println("First Name of employee : "+employee2.getFirstName());
        System.out.println("Last Name of employee : "+employee2.getLastName());
        System.out.println("Age of employee : "+employee2.getAge());
        System.out.println("Gender of employee : "+employee2.getGender());
        System.out.println("Salary of employee : "+employee2.getSalary());
        System.out.println("Marital status of employee : "+employee2.getMarried());
    }

    public static void main(String[] args) throws IOException {
        RestAssured_POJO obj = new RestAssured_POJO();
        obj.getPojoFromEmployeeObject();
    }
}
