package my.project.dto.create;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Component
public class CreateWebParamToEntityDataBase {

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
}
