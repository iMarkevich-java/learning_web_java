package my.project.dto;

import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDtoForCreate {

    private String employeeId;
    private MultipartFile employeePhoto;
    private String employeeFirstName;
    private String employeeSurname;
    private Date employeeDateOfBorn;
    private String employeePosition;

    public EmployeeDtoForCreate() {
    }

    public void checkParameters(MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        try {
            checkAllParameterOnException(employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        } catch (EmployeeWebException e) {
            List<String> errorList = e.getErrorList();
            throw new EmployeeWebException(errorList);
        }
        this.employeePhoto = employeePhotoParam;
        this.employeeFirstName = employeeFirstNameParam;
        this.employeeSurname = employeeSurnameParam;
        this.employeeDateOfBorn = employeeDateOfBornParam;
        this.employeePosition = employeePositionParam;
    }

    public Employee convertEmployeeDtoToEmployee() {
        Blob employeePhotoBlob = new ConvertMultiPartFileToBlob().convertCreatePhoto(employeePhoto);
        return Employee
                .builder()
                .photo(employeePhotoBlob)
                .employeeFirstName(employeeFirstName)
                .employeeSurname(employeeSurname)
                .employeeDateOfBorn(employeeDateOfBorn)
                .employeePosition(employeePosition)
                .build();
    }

    private void checkAllParameterOnException(MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeePhotoParam.isEmpty()) {
            String errorMessage = "Employee id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeFirstNameParam.isEmpty()) {
            String errorMessage = "Employee first name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeSurnameParam.isEmpty()) {
            String errorMessage = "Employee surname can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeDateOfBornParam.toString().isEmpty()) {
            String errorMessage = "Employee date of born can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeePositionParam.isEmpty()) {
            String errorMessage = "Employee position can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new EmployeeWebException(errorList);
        }
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public MultipartFile getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(MultipartFile employeePhoto) {
        this.employeePhoto = employeePhoto;
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

}
