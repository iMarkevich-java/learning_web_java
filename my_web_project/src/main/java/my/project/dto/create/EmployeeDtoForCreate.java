package my.project.dto.create;

import my.project.dto.ConvertMultiPartFileToBlob;
import my.project.entity.Employee;
import my.project.entity.Positions;
import my.project.exceptions.EmployeeWebException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

@Component
public class EmployeeDtoForCreate {

    private String createEmployeeId;
    private MultipartFile createEmployeePhoto;
    private String createEmployeeFirstName;
    private String createEmployeeSurname;
    private Date createEmployeeDateOfBorn;
    private String createEmployeePosition;

    public EmployeeDtoForCreate() {
    }

    public void checkParameters(MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeePhotoParam == null) {
            String errorMessage = "Employee photo can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeFirstNameParam.isEmpty()) {
            String errorMessage = "Employee first name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeSurnameParam.isEmpty()) {
            String errorMessage = "Employee surname can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeDateOfBornParam.toString().isEmpty()) {
            String errorMessage = "Employee date of born can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (!(employeePositionParam.equals(Positions.DEVELOPER.getPosition()) || employeePositionParam.equals(Positions.MANAGER.getPosition()) || employeePositionParam.equals(Positions.QA_ENGINEER.getPosition()))) {
            String errorMessage = "Employee position can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new EmployeeWebException(errorList);
        }
        this.createEmployeePhoto = employeePhotoParam;
        this.createEmployeeFirstName = employeeFirstNameParam;
        this.createEmployeeSurname = employeeSurnameParam;
        this.createEmployeeDateOfBorn = employeeDateOfBornParam;
        this.createEmployeePosition = employeePositionParam;
    }

    public Employee convertEmployeeDtoToEmployee() {
        Blob employeePhotoBlob = new ConvertMultiPartFileToBlob().convertCreatePhoto(createEmployeePhoto);
        return Employee
                .builder()
                .photo(employeePhotoBlob)
                .employeeFirstName(createEmployeeFirstName)
                .employeeSurname(createEmployeeSurname)
                .employeeDateOfBorn(createEmployeeDateOfBorn)
                .employeePosition(createEmployeePosition)
                .build();
    }
}
