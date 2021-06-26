package my.project.dto.create;

import my.project.entity.Positions;
import my.project.exceptions.AddressWebException;
import my.project.exceptions.AllEntityWebException;
import my.project.exceptions.EmployeeWebException;
import my.project.exceptions.PositionWebException;
import my.project.service.employee.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateEntityDataBase {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private QAEngineerService qaEngineerService;

    @Autowired
    private EmployeeDtoForCreate employeeDtoForCreate;

    @Autowired
    private AddressDtoForCreate addressDtoForCreate;

    @Autowired
    private PositionDtoForCreate positionDtoForCreate;

    public void create(CreateWebParamToEntityDataBase createWebParamToEntityDataBase) {
        ArrayList<String> errorList = new ArrayList<>();
        try {
            employeeDtoForCreate.checkParameters(createWebParamToEntityDataBase.getEmployeePhotoParam(), createWebParamToEntityDataBase.getEmployeeFirstNameParam(),
                    createWebParamToEntityDataBase.getEmployeeSurnameParam(), createWebParamToEntityDataBase.getEmployeeDateOfBornParam(),
                    createWebParamToEntityDataBase.getEmployeePositionParam());
        } catch (EmployeeWebException e) {
            List<String> errorListEmployee = e.getErrorList();
            errorList.addAll(errorListEmployee);
        }
        try {
            addressDtoForCreate.checkParameters(createWebParamToEntityDataBase.getAddressCountryParam(), createWebParamToEntityDataBase.getAddressRegionParam(),
                    createWebParamToEntityDataBase.getAddressLocalityParam(), createWebParamToEntityDataBase.getAddressCityParam(),
                    createWebParamToEntityDataBase.getAddressStreetParam(), createWebParamToEntityDataBase.getAddressHouseParam(),
                    createWebParamToEntityDataBase.getAddressFlatParam());
        } catch (AddressWebException e) {
            List<String> errorListAddress = e.getErrorList();
            errorList.addAll(errorListAddress);
        }
        try {
            positionDtoForCreate.checkParameters(createWebParamToEntityDataBase.getDepartmentParam(), createWebParamToEntityDataBase.getExperienceParam());
        } catch (PositionWebException e) {
            List<String> errorListPosition = e.getErrorList();
            errorList.addAll(errorListPosition);
        }
        if (!(errorList.isEmpty())) {
            throw new AllEntityWebException(errorList);
        }

        BigInteger employeeId = employeeService.createEmployee(employeeDtoForCreate.convertEmployeeDtoToEmployee());
        addressService.createAddress(addressDtoForCreate.convertAddressDtoToAddress(), employeeId);
        if (createWebParamToEntityDataBase.getEmployeePositionParam().equals(Positions.MANAGER.getPosition())) {
            managerService.createManager(positionDtoForCreate.readCreateManager(), employeeId);
        }
        if (createWebParamToEntityDataBase.getEmployeePositionParam().equals(Positions.DEVELOPER.getPosition())) {
            developerService.createDeveloper(positionDtoForCreate.readCreateDeveloper(), employeeId);
        }
        if (createWebParamToEntityDataBase.getEmployeePositionParam().equals(Positions.QA_ENGINEER.getPosition())) {
            qaEngineerService.createQAEngineer(positionDtoForCreate.readCreateQaEngineer(), employeeId);
        }
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
}
