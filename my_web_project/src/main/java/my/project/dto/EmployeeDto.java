package my.project.dto;

import my.project.entity.Employee;

import java.math.BigInteger;
import java.sql.Date;

public class EmployeeDto {

    private String employeeId;
    private String employeeFirstName;
    private String employeeSurname;
    private Date employeeDateOfBorn;
    private String employeePosition;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        this.employeeFirstName = employeeFirstNameParam;
        this.employeeSurname = employeeSurnameParam;
        this.employeeDateOfBorn = employeeDateOfBornParam;
        this.employeePosition = employeePositionParam;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public Date getEmployeeDateOfBorn() {
        return employeeDateOfBorn;
    }

    public void setEmployeeDateOfBorn(Date employeeDateOfBorn) {
        this.employeeDateOfBorn = employeeDateOfBorn;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Employee convertEmployeeDtoToEmployee(EmployeeDto employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(new BigInteger(employeeDTO.getEmployeeId()));
        employee.setEmployeeFirstName(employeeDTO.getEmployeeFirstName());
        employee.setEmployeeSurname(employeeDTO.getEmployeeSurname());
        employee.setEmployeeDateOfBorn(employeeDTO.getEmployeeDateOfBorn());
        employee.setEmployeePosition(employeeDTO.getEmployeePosition());
        return employee;
    }
}
