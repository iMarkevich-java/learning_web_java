package my.project.dto.update;

import my.project.dto.ConvertMultiPartFileToBlob;
import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

@Component
public class EmployeeDtoForUpdate {

    private String updateEmployeeIdParam;
    private MultipartFile updateEmployeePhotoParam;
    private String updateEmployeeFirstNameParam;
    private String updateEmployeeSurnameParam;
    private Date updateEmployeeDateOfBornParam;
    private String updateEmployeePositionParam;

    public EmployeeDtoForUpdate() {
    }

    public void checkParameters(String updateEmployeeIdParam, MultipartFile updateEmployeePhotoParam,
                                String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam,
                                Date updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        try {
            new BigInteger(updateEmployeeIdParam);
        } catch (Exception e) {
            String errorMessage = "Can't parsing String employee id to BigInteger employee id in class" + getClass().getName();
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateEmployeeIdParam.isEmpty()) {
            String errorMessage = "Employee id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateEmployeePhotoParam.isEmpty()) {
            String errorMessage = "Employee id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateEmployeeFirstNameParam.isEmpty()) {
            String errorMessage = "Employee first name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateEmployeeSurnameParam.isEmpty()) {
            String errorMessage = "Employee surname can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateEmployeeDateOfBornParam.toString().isEmpty()) {
            String errorMessage = "Employee date of born can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateEmployeePositionParam.isEmpty()) {
            String errorMessage = "Employee position can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new EmployeeWebException(errorList);
        }
        this.updateEmployeeIdParam = updateEmployeeIdParam;
        this.updateEmployeePhotoParam = updateEmployeePhotoParam;
        this.updateEmployeeFirstNameParam = updateEmployeeFirstNameParam;
        this.updateEmployeeSurnameParam = updateEmployeeSurnameParam;
        this.updateEmployeeDateOfBornParam = updateEmployeeDateOfBornParam;
        this.updateEmployeePositionParam = updateEmployeePositionParam;
    }

    public Employee convertEmployeeDtoToEmployee() {
        Blob employeePhotoBlob = new ConvertMultiPartFileToBlob().convertCreatePhoto(updateEmployeePhotoParam);
        BigInteger employeeId = new BigInteger(updateEmployeeIdParam);
        return Employee
                .builder()
                .employeeId(employeeId)
                .photo(employeePhotoBlob)
                .employeeFirstName(updateEmployeeFirstNameParam)
                .employeeSurname(updateEmployeeSurnameParam)
                .employeeDateOfBorn(updateEmployeeDateOfBornParam)
                .employeePosition(updateEmployeePositionParam)
                .build();
    }
}
