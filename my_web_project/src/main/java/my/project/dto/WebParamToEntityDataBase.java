package my.project.dto;

import my.project.entity.*;
import my.project.exceptions.EmployeeWebException;
import my.project.service.communication.EmployeeAddressCommunicationService;
import my.project.service.communication.EmployeeDeveloperCommunicationService;
import my.project.service.communication.EmployeeManagerCommunicationService;
import my.project.service.communication.EmployeeQAEngineerCommunicationService;
import my.project.service.entity.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Component
public class WebParamToEntityDataBase {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    AddressService addressService;
    @Autowired
    ManagerService managerService;
    @Autowired
    DeveloperService developerService;
    @Autowired
    QAEngineerService qaEngineerService;
    @Autowired
    EmployeeAddressCommunicationService employeeAddressCommunicationService;
    @Autowired
    EmployeeManagerCommunicationService employeeManagerCommunicationService;
    @Autowired
    EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService;
    @Autowired
    EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService;


    private MultipartFile updateEmployeePhotoParam;
    private String updateEmployeeIdParam;
    private String updateEmployeeFirstNameParam;
    private String updateEmployeeSurnameParam;
    private Date updateEmployeeDateOfBornParam;
    private String updateEmployeePositionParam;
    private String updateDepartmentParam;
    private String updateExperienceParam;
    private String updateAddressIdParam;
    private String updateAddressCountryParam;
    private String updateAddressRegionParam;
    private String updateAddressLocalityParam;
    private String updateAddressCityParam;
    private String updateAddressStreetParam;
    private String updateAddressHouseParam;
    private String updateAddressFlatParam;

    private Employee employee;
    private Address address;
    private Manager manager;
    private Developer developer;
    private QaEngineer qaEngineer;

    public WebParamToEntityDataBase() {
    }

    public void update() {
//        Blob employeePhotoBlob = convertMultiPartFileToBlob(updateEmployeePhotoParam, "src/main/webapp/images/employeePhoto.jpg");
//        Employee employee = employeeService.readEmployeeById(updateEmployeeIdParam);
//        BigInteger addressId = employee.getAddress().getAddressId();
//        Employee updateEmployee = new Employee(new BigInteger(updateEmployeeIdParam), employeePhotoBlob, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
//        if(Employee){
//            BigInteger managerId = employee.getManager().getManagerId();
//            qaEngineerService.updateQAEngineerById(updateEmployee);
//            employeeAddressCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), addressId);
//            employeeManagerCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), managerId);
//        }
//        if(updateEmployee.getDeveloper() != null){
//            BigInteger developerId = employee.getDeveloper().getDeveloperId();
//            employeeService.updateEmployeeById(updateEmployee);
//            employeeAddressCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), addressId);
//            employeeDeveloperCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), developerId);
//        }
//        if(updateEmployee.getQaEngineer() != null){
//            BigInteger qaEngineerId = employee.getQaEngineer().getqAEngineerId();
//            employeeService.updateEmployeeById(updateEmployee);
//            employeeAddressCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), addressId);
//            employeeQAEngineerCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), qaEngineerId);
//        }
    }

    public Blob convertMultiPartFileToBlob(MultipartFile photoParam, String pathEmployeeImage) {
        Blob photoBlob = null;
        if (!(photoParam.isEmpty())) {
            try (InputStream inputStreamImage = photoParam.getInputStream()) {
                byte[] imageByte = IOUtils.toByteArray(inputStreamImage);
                photoBlob = new SerialBlob(imageByte);
            } catch (IOException | SQLException e) {
                List<String> errorList = new EmployeeWebException().getErrorList();
                errorList.add(e.getMessage());
                new EmployeeWebException().setErrorList(errorList);
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(pathEmployeeImage)) {
                byte[] imageByte = IOUtils.toByteArray(fileInputStream);
                photoBlob = new SerialBlob(imageByte);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return photoBlob;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    public ManagerService getManagerService() {
        return managerService;
    }

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public DeveloperService getDeveloperService() {
        return developerService;
    }

    public void setDeveloperService(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public QAEngineerService getQaEngineerService() {
        return qaEngineerService;
    }

    public void setQaEngineerService(QAEngineerService qaEngineerService) {
        this.qaEngineerService = qaEngineerService;
    }

    public EmployeeAddressCommunicationService getEmployeeAddressCommunicationService() {
        return employeeAddressCommunicationService;
    }

    public void setEmployeeAddressCommunicationService(EmployeeAddressCommunicationService employeeAddressCommunicationService) {
        this.employeeAddressCommunicationService = employeeAddressCommunicationService;
    }

    public EmployeeManagerCommunicationService getEmployeeManagerCommunicationService() {
        return employeeManagerCommunicationService;
    }

    public void setEmployeeManagerCommunicationService(EmployeeManagerCommunicationService employeeManagerCommunicationService) {
        this.employeeManagerCommunicationService = employeeManagerCommunicationService;
    }

    public EmployeeDeveloperCommunicationService getEmployeeDeveloperCommunicationService() {
        return employeeDeveloperCommunicationService;
    }

    public void setEmployeeDeveloperCommunicationService(EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService) {
        this.employeeDeveloperCommunicationService = employeeDeveloperCommunicationService;
    }

    public EmployeeQAEngineerCommunicationService getEmployeeQAEngineerCommunicationService() {
        return employeeQAEngineerCommunicationService;
    }

    public void setEmployeeQAEngineerCommunicationService(EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService) {
        this.employeeQAEngineerCommunicationService = employeeQAEngineerCommunicationService;
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

    public String getUpdateExperienceParam() {
        return updateExperienceParam;
    }

    public void setUpdateExperienceParam(String updateExperienceParam) {
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

    public String getUpdateAddressHouseParam() {
        return updateAddressHouseParam;
    }

    public void setUpdateAddressHouseParam(String updateAddressHouseParam) {
        this.updateAddressHouseParam = updateAddressHouseParam;
    }

    public String getUpdateAddressFlatParam() {
        return updateAddressFlatParam;
    }

    public void setUpdateAddressFlatParam(String updateAddressFlatParam) {
        this.updateAddressFlatParam = updateAddressFlatParam;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public QaEngineer getQaEngineer() {
        return qaEngineer;
    }

    public void setQaEngineer(QaEngineer qaEngineer) {
        this.qaEngineer = qaEngineer;
    }
}
