package my.project.dto.update;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
    private String updateManagerIdParam;
    private String updateDeveloperIdParam;
    private String updateQaEngineerIdParam;
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

    public String getUpdateManagerIdParam() {
        return updateManagerIdParam;
    }

    public void setUpdateManagerIdParam(String updateManagerIdParam) {
        this.updateManagerIdParam = updateManagerIdParam;
    }

    public String getUpdateDeveloperIdParam() {
        return updateDeveloperIdParam;
    }

    public void setUpdateDeveloperIdParam(String updateDeveloperIdParam) {
        this.updateDeveloperIdParam = updateDeveloperIdParam;
    }

    public String getUpdateQaEngineerIdParam() {
        return updateQaEngineerIdParam;
    }

    public void setUpdateQaEngineerIdParam(String updateQaEngineerIdParam) {
        this.updateQaEngineerIdParam = updateQaEngineerIdParam;
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