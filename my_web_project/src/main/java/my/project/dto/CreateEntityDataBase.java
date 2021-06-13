package my.project.dto;

import my.project.entity.Positions;
import my.project.exceptions.AllEntityWebException;
import my.project.exceptions.EmployeeWebException;
import my.project.service.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
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

    public void create(CreateWebParamToEntityDataBase createWebParamToEntityDataBase) {
        try {
            BigInteger employeeId = employeeService.createEmployee(createWebParamToEntityDataBase.readCreateEmployee());
            addressService.createAddress(createWebParamToEntityDataBase.readCreateAddress(), employeeId);

            if (createWebParamToEntityDataBase.getEmployeePositionParam().equals(Positions.MANAGER.getPosition())) {
                managerService.createManager(createWebParamToEntityDataBase.readCreateManager(), employeeId);
            }
            if (createWebParamToEntityDataBase.getEmployeePositionParam().equals(Positions.DEVELOPER.getPosition())) {
                developerService.createDeveloper(createWebParamToEntityDataBase.readCreateDeveloper(), employeeId);
            }
            if (createWebParamToEntityDataBase.getEmployeePositionParam().equals(Positions.QA_ENGINEER.getPosition())) {
                qaEngineerService.createQAEngineer(createWebParamToEntityDataBase.readCreateQaEngineer(), employeeId);
            }
        } catch (EmployeeWebException e) {
            List<String> errorList = e.getErrorList();
            throw new AllEntityWebException(errorList);
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
