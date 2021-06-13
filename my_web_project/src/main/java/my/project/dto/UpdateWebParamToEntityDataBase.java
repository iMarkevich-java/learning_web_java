package my.project.dto;

import my.project.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;

@Component
public class UpdateWebParamToEntityDataBase {

    private MultipartFile updateEmployeePhotoParam;
    private String updateEmployeeIdParam;
    private String updateEmployeeFirstNameParam;
    private String updateEmployeeSurnameParam;
    private Date updateEmployeeDateOfBornParam;
    private String updateEmployeePositionParam;
    private String updateDepartmentParam;
    private int updateExperienceParam;
    private String updateAddressIdParam;
    private String updateAddressCountryParam;
    private String updateAddressRegionParam;
    private String updateAddressLocalityParam;
    private String updateAddressCityParam;
    private String updateAddressStreetParam;
    private int updateAddressHouseParam;
    private int updateAddressFlatParam;

    public UpdateWebParamToEntityDataBase() {
    }

    public Employee readUpdateEmployee() {
        Blob employeePhotoBlob = new ConvertMultiPartFileToBlob().convertUpdatePhoto(updateEmployeePhotoParam);
        BigInteger updateEmployeeIdBigInteger = new BigInteger(updateEmployeeIdParam);
        return Employee
                .builder()
                .employeeId(updateEmployeeIdBigInteger)
                .photo(employeePhotoBlob)
                .employeeFirstName(updateEmployeeFirstNameParam)
                .employeeSurname(updateEmployeeSurnameParam)
                .employeeDateOfBorn(updateEmployeeDateOfBornParam)
                .employeePosition(updateEmployeePositionParam)
                .employeePosition(updateEmployeePositionParam)
                .build();
    }

    public Address readUpdateAddress() {
        BigInteger updateAddressIdBigInteger = new BigInteger(updateAddressIdParam);
        return Address
                .builder()
                .addressId(updateAddressIdBigInteger)
                .country(updateAddressCountryParam)
                .region(updateAddressRegionParam)
                .locality(updateAddressLocalityParam)
                .city(updateAddressCityParam)
                .street(updateAddressStreetParam)
                .house(updateAddressHouseParam)
                .flat(updateAddressFlatParam)
                .build();
    }

    public Manager readUpdateManager() {
        return Manager
                .builder()
                .managerDepartment(updateDepartmentParam)
                .managerExperience(updateExperienceParam)
                .build();
    }

    public QaEngineer readUpdateQaEngineer() {
        return QaEngineer
                .builder()
                .qaEngineerDepartment(updateDepartmentParam)
                .qaEngineerExperience(updateExperienceParam)
                .build();
    }

    public Developer readUpdateDeveloper() {
        return Developer
                .builder()
                .developerDepartment(updateDepartmentParam)
                .developerExperience(updateExperienceParam)
                .build();
    }

    public MultipartFile getUpdateEmployeePhotoParam() {
        return updateEmployeePhotoParam;
    }

    public void setUpdateEmployeePhotoParam(MultipartFile updateEmployeePhotoParam) {
        this.updateEmployeePhotoParam = updateEmployeePhotoParam;
    }

    public String getUpdateEmployeeIdParam() {
        return updateEmployeeIdParam;
    }

    public void setUpdateEmployeeIdParam(String updateEmployeeIdParam) {
        this.updateEmployeeIdParam = updateEmployeeIdParam;
    }

    public String getUpdateEmployeeFirstNameParam() {
        return updateEmployeeFirstNameParam;
    }

    public void setUpdateEmployeeFirstNameParam(String updateEmployeeFirstNameParam) {
        this.updateEmployeeFirstNameParam = updateEmployeeFirstNameParam;
    }

    public String getUpdateEmployeeSurnameParam() {
        return updateEmployeeSurnameParam;
    }

    public void setUpdateEmployeeSurnameParam(String updateEmployeeSurnameParam) {
        this.updateEmployeeSurnameParam = updateEmployeeSurnameParam;
    }

    public Date getUpdateEmployeeDateOfBornParam() {
        return updateEmployeeDateOfBornParam;
    }

    public void setUpdateEmployeeDateOfBornParam(Date updateEmployeeDateOfBornParam) {
        this.updateEmployeeDateOfBornParam = updateEmployeeDateOfBornParam;
    }

    public String getUpdateEmployeePositionParam() {
        return updateEmployeePositionParam;
    }

    public void setUpdateEmployeePositionParam(String updateEmployeePositionParam) {
        this.updateEmployeePositionParam = updateEmployeePositionParam;
    }

    public String getUpdateDepartmentParam() {
        return updateDepartmentParam;
    }

    public void setUpdateDepartmentParam(String updateDepartmentParam) {
        this.updateDepartmentParam = updateDepartmentParam;
    }

    public int getUpdateExperienceParam() {
        return updateExperienceParam;
    }

    public void setUpdateExperienceParam(int updateExperienceParam) {
        this.updateExperienceParam = updateExperienceParam;
    }

    public String getUpdateAddressIdParam() {
        return updateAddressIdParam;
    }

    public void setUpdateAddressIdParam(String updateAddressIdParam) {
        this.updateAddressIdParam = updateAddressIdParam;
    }

    public String getUpdateAddressCountryParam() {
        return updateAddressCountryParam;
    }

    public void setUpdateAddressCountryParam(String updateAddressCountryParam) {
        this.updateAddressCountryParam = updateAddressCountryParam;
    }

    public String getUpdateAddressRegionParam() {
        return updateAddressRegionParam;
    }

    public void setUpdateAddressRegionParam(String updateAddressRegionParam) {
        this.updateAddressRegionParam = updateAddressRegionParam;
    }

    public String getUpdateAddressLocalityParam() {
        return updateAddressLocalityParam;
    }

    public void setUpdateAddressLocalityParam(String updateAddressLocalityParam) {
        this.updateAddressLocalityParam = updateAddressLocalityParam;
    }

    public String getUpdateAddressCityParam() {
        return updateAddressCityParam;
    }

    public void setUpdateAddressCityParam(String updateAddressCityParam) {
        this.updateAddressCityParam = updateAddressCityParam;
    }

    public String getUpdateAddressStreetParam() {
        return updateAddressStreetParam;
    }

    public void setUpdateAddressStreetParam(String updateAddressStreetParam) {
        this.updateAddressStreetParam = updateAddressStreetParam;
    }

    public int getUpdateAddressHouseParam() {
        return updateAddressHouseParam;
    }

    public void setUpdateAddressHouseParam(int updateAddressHouseParam) {
        this.updateAddressHouseParam = updateAddressHouseParam;
    }

    public int getUpdateAddressFlatParam() {
        return updateAddressFlatParam;
    }

    public void setUpdateAddressFlatParam(int updateAddressFlatParam) {
        this.updateAddressFlatParam = updateAddressFlatParam;
    }
}