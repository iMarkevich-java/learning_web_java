package my.project.dto;

import my.project.entity.*;
import my.project.exceptions.AllEntityWebException;
import my.project.exceptions.EmployeeWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@Component
public class CreateWebParamToEntityDataBase {

    @Autowired
    private EmployeeDtoForCreate employeeDtoForCreate;

    private MultipartFile employeePhotoParam;
    private String employeeFirstNameParam;
    private String employeeSurnameParam;
    private Date employeeDateOfBornParam;
    private String employeePositionParam;
    private String departmentParam;
    private int experienceParam;
    private String addressCountryParam;
    private String addressRegionParam;
    private String addressLocalityParam;
    private String addressCityParam;
    private String addressStreetParam;
    private int addressHouseParam;
    private int addressFlatParam;

    public CreateWebParamToEntityDataBase() {
    }

    public Employee readCreateEmployee() {
        try {
            employeeDtoForCreate.checkParameters(employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        } catch (EmployeeWebException e) {
            List<String> errorList = e.getErrorList();
            throw new AllEntityWebException(errorList);
        }
        return employeeDtoForCreate.convertEmployeeDtoToEmployee();
    }

    public Address readCreateAddress() {
        return Address
                .builder()
                .country(addressCountryParam)
                .region(addressRegionParam)
                .locality(addressLocalityParam)
                .city(addressCityParam)
                .street(addressStreetParam)
                .house(addressHouseParam)
                .flat(addressFlatParam)
                .build();
    }

    public Manager readCreateManager() {
        return Manager
                .builder()
                .managerDepartment(departmentParam)
                .managerExperience(experienceParam)
                .build();
    }

    public QaEngineer readCreateQaEngineer() {
        return QaEngineer
                .builder()
                .qaEngineerDepartment(departmentParam)
                .qaEngineerExperience(experienceParam)
                .build();
    }

    public Developer readCreateDeveloper() {
        return Developer
                .builder()
                .developerDepartment(departmentParam)
                .developerExperience(experienceParam)
                .build();
    }

    public MultipartFile getEmployeePhotoParam() {
        return employeePhotoParam;
    }

    public void setEmployeePhotoParam(MultipartFile employeePhotoParam) {
        this.employeePhotoParam = employeePhotoParam;
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

    public String getDepartmentParam() {
        return departmentParam;
    }

    public void setDepartmentParam(String departmentParam) {
        this.departmentParam = departmentParam;
    }

    public int getExperienceParam() {
        return experienceParam;
    }

    public void setExperienceParam(int experienceParam) {
        this.experienceParam = experienceParam;
    }

    public String getAddressCountryParam() {
        return addressCountryParam;
    }

    public void setAddressCountryParam(String addressCountryParam) {
        this.addressCountryParam = addressCountryParam;
    }

    public String getAddressRegionParam() {
        return addressRegionParam;
    }

    public void setAddressRegionParam(String addressRegionParam) {
        this.addressRegionParam = addressRegionParam;
    }

    public String getAddressLocalityParam() {
        return addressLocalityParam;
    }

    public void setAddressLocalityParam(String addressLocalityParam) {
        this.addressLocalityParam = addressLocalityParam;
    }

    public String getAddressCityParam() {
        return addressCityParam;
    }

    public void setAddressCityParam(String addressCityParam) {
        this.addressCityParam = addressCityParam;
    }

    public String getAddressStreetParam() {
        return addressStreetParam;
    }

    public void setAddressStreetParam(String addressStreetParam) {
        this.addressStreetParam = addressStreetParam;
    }

    public int getAddressHouseParam() {
        return addressHouseParam;
    }

    public void setAddressHouseParam(int addressHouseParam) {
        this.addressHouseParam = addressHouseParam;
    }

    public int getAddressFlatParam() {
        return addressFlatParam;
    }

    public void setAddressFlatParam(int addressFlatParam) {
        this.addressFlatParam = addressFlatParam;
    }

    public EmployeeDtoForCreate getEmployeeDtoForCreate() {
        return employeeDtoForCreate;
    }

    public void setEmployeeDtoForCreate(EmployeeDtoForCreate employeeDtoForCreate) {
        this.employeeDtoForCreate = employeeDtoForCreate;
    }
}
