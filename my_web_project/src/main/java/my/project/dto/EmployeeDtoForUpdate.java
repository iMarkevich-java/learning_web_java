package my.project.dto;

import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

public class EmployeeDtoForUpdate {

    private String updateEmployeeId;
    private MultipartFile updateEmployeePhoto;
    private String updateEmployeeFirstName;
    private String updateEmployeeSurname;
    private Date updateEmployeeDateOfBorn;
    private String updateEmployeePosition;

    public EmployeeDtoForUpdate() {
    }

    public void checkParameters(String employeeIdParam, MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        checkAllParameterOnException(employeeIdParam, employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        this.updateEmployeeId = employeeIdParam;
        this.updateEmployeePhoto = employeePhotoParam;
        this.updateEmployeeFirstName = employeeFirstNameParam;
        this.updateEmployeeSurname = employeeSurnameParam;
        this.updateEmployeeDateOfBorn = employeeDateOfBornParam;
        this.updateEmployeePosition = employeePositionParam;
    }

    public Employee convertEmployeeDtoToEmployee() {
        Blob employeePhotoBlob = new ConvertMultiPartFileToBlob().convertCreatePhoto(updateEmployeePhoto);
        BigInteger employeeId = new BigInteger(updateEmployeeId);
        return Employee
                .builder()
                .employeeId(employeeId)
                .photo(employeePhotoBlob)
                .employeeFirstName(updateEmployeeFirstName)
                .employeeSurname(updateEmployeeSurname)
                .employeeDateOfBorn(updateEmployeeDateOfBorn)
                .employeePosition(updateEmployeePosition)
                .build();
    }

    private void checkAllParameterOnException(String employeeIdParam, MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeIdParam.isEmpty()) {
            String errorMessage = "Employee id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
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
}
