package my.project.dto;

import my.project.entity.Employee;

import java.sql.Date;

public class EmployeeDTO {

    private String employeeFirstNameParam;
    private String employeeSurnameParam;
    private Date employeeDateOfBornParam;
    private String employeePositionParam;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        this.employeeFirstNameParam = employeeFirstNameParam;
        this.employeeSurnameParam = employeeSurnameParam;
        this.employeeDateOfBornParam = employeeDateOfBornParam;
        this.employeePositionParam = employeePositionParam;
    }

    public String getEmployeeFirstNameParam() {
        return employeeFirstNameParam;
    }

    public void setEmployeeFirstNameParam(String employeeFirstNameParam) {
        this.employeeFirstNameParam = employeeFirstNameParam;
    }

    public String getEmployeeSurnameParam() {
        return employeeSurnameParam;
    }

    public void setEmployeeSurnameParam(String employeeSurnameParam) {
        this.employeeSurnameParam = employeeSurnameParam;
    }

    public Date getEmployeeDateOfBornParam() {
        return employeeDateOfBornParam;
    }

    public void setEmployeeDateOfBornParam(Date employeeDateOfBornParam) {
        this.employeeDateOfBornParam = employeeDateOfBornParam;
    }

    public String getEmployeePositionParam() {
        return employeePositionParam;
    }

    public void setEmployeePositionParam(String employeePositionParam) {
        this.employeePositionParam = employeePositionParam;
    }

    public Employee convertEmployeeDtoToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeFirstName(employeeDTO.getEmployeeFirstNameParam());
        employee.setEmployeeSurname(employeeDTO.getEmployeeSurnameParam());
        employee.setEmployeeDateOfBorn(employeeDTO.getEmployeeDateOfBornParam());
        employee.setEmployeePosition(employeeDTO.getEmployeePositionParam());
        return employee;
    }
}
