package tech.kevin.employee_manager.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import java.io.Serializable;

@Document(collection = "employees")
public class Employee implements Serializable {

    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imgURL;
    private String employeeCode;

    public Employee(){}

    public Employee(String id, String name, String email, String jobTitle, String phoneNumber, String imgURL, String employeeCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.imgURL = imgURL;
        this.employeeCode = employeeCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString(){
        return "Employee{" + "id = '" + id + ", name = '" + name + '\'' + "\n" +
                ", email = '" + email + '\'' + "\n" +
                ", jobTitle = '" + jobTitle + '\'' + "\n" +
                ", phoneNumber = '" + phoneNumber + '\'' + "\n" +
                ", imgURL = '" + imgURL + '\'' + "\n" +
                '}';
    }
}
