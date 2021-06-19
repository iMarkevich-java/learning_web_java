package my.project.dto.update;

import my.project.entity.Employee;
import my.project.entity.Positions;
import my.project.exceptions.AddressWebException;
import my.project.exceptions.AllEntityWebException;
import my.project.exceptions.EmployeeWebException;
import my.project.exceptions.PositionWebException;
import my.project.service.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateEntityDataBase {

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
    private EmployeeDtoForUpdate employeeDtoForUpdate;

    @Autowired
    private AddressDtoForUpdate addressDtoForUpdate;

    @Autowired
    private PositionDtoForUpdate positionDtoForUpdate;

    public void update(UpdateWebParamToEntityDataBase updateWebParamToEntityDataBase) {
        ArrayList<String> errorList = new ArrayList<>();
        try {
            employeeDtoForUpdate.checkParameters(updateWebParamToEntityDataBase.getUpdateEmployeeIdParam(),
                    updateWebParamToEntityDataBase.getUpdateEmployeePhotoParam(),
                    updateWebParamToEntityDataBase.getUpdateEmployeeFirstNameParam(),
                    updateWebParamToEntityDataBase.getUpdateEmployeeSurnameParam(),
                    updateWebParamToEntityDataBase.getUpdateEmployeeDateOfBornParam(),
                    updateWebParamToEntityDataBase.getUpdateEmployeePositionParam());
        } catch (EmployeeWebException e) {
            List<String> errorListEmployee = e.getErrorList();
            errorList.addAll(errorListEmployee);
        }
        try {
            addressDtoForUpdate.checkParameters(updateWebParamToEntityDataBase.getUpdateAddressIdParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressCountryParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressRegionParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressLocalityParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressCityParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressStreetParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressHouseParam(),
                    updateWebParamToEntityDataBase.getUpdateAddressFlatParam());
        } catch (AddressWebException e) {
            List<String> errorListAddress = e.getErrorList();
            errorList.addAll(errorListAddress);
        }
        try {
            positionDtoForUpdate.checkParameters(updateWebParamToEntityDataBase.getUpdateDepartmentParam(),
                    updateWebParamToEntityDataBase.getUpdateExperienceParam(),
                    updateWebParamToEntityDataBase.getUpdateManagerIdParam(),
                    updateWebParamToEntityDataBase.getUpdateDeveloperIdParam(),
                    updateWebParamToEntityDataBase.getUpdateQaEngineerIdParam());
        } catch (PositionWebException e) {
            List<String> errorListPosition = e.getErrorList();
            errorList.addAll(errorListPosition);
        }
        if (!(errorList.isEmpty())) {
            throw new AllEntityWebException(errorList);
        }

        Employee employee = employeeService.readEmployeeById(updateWebParamToEntityDataBase.getUpdateEmployeeIdParam());
        String employeePosition = employee.getEmployeePosition();
        BigInteger employeeId = employee.getEmployeeId();
        employeeService.updateEmployee(employeeDtoForUpdate.convertEmployeeDtoToEmployee());
        addressService.updateAddress(addressDtoForUpdate.convertAddressDtoToAddress());
        if (updateWebParamToEntityDataBase.getUpdateEmployeePositionParam().equals(Positions.MANAGER.getPosition())) {
            if(employeePosition.equals(Positions.DEVELOPER.getPosition())){
                developerService.deleteDeveloperById(employee.getDeveloper().getDeveloperId());
            }else if(employeePosition.equals(Positions.QA_ENGINEER.getPosition())){
                qaEngineerService.deleteQAEngineerById(employee.getQaEngineer().getQaEngineerId());
            }

            if(employeePosition.equals(Positions.MANAGER.getPosition())){
                managerService.updateManager(positionDtoForUpdate.readUpdateManager());
            }else {
                managerService.createManager(positionDtoForUpdate.readManagerForCreate(), employeeId);
            }
        }
        if (updateWebParamToEntityDataBase.getUpdateEmployeePositionParam().equals(Positions.DEVELOPER.getPosition())) {
            if(employeePosition.equals(Positions.MANAGER.getPosition())){
                managerService.deleteManagerById(employee.getManager().getManagerId());
            }else if(employeePosition.equals(Positions.QA_ENGINEER.getPosition())){
                qaEngineerService.deleteQAEngineerById(employee.getQaEngineer().getQaEngineerId());
            }

            if(employeePosition.equals(Positions.DEVELOPER.getPosition())){
                developerService.updateDeveloper(positionDtoForUpdate.readUpdateDeveloper());
            }else {
               developerService.createDeveloper(positionDtoForUpdate.readDeveloperForCreate(), employeeId);
            }
        }
        if (updateWebParamToEntityDataBase.getUpdateEmployeePositionParam().equals(Positions.QA_ENGINEER.getPosition())) {
            if(employeePosition.equals(Positions.MANAGER.getPosition())){
                managerService.deleteManagerById(employee.getManager().getManagerId());
            }else if(employeePosition.equals(Positions.DEVELOPER.getPosition())){
                developerService.deleteDeveloperById(employee.getDeveloper().getDeveloperId());
            }

            if(employeePosition.equals(Positions.QA_ENGINEER.getPosition())){
                qaEngineerService.updateQAEngineer(positionDtoForUpdate.readUpdateQaEngineer());
            }else {
                qaEngineerService.createQAEngineer(positionDtoForUpdate.readQaEngineerForCreate(), employeeId);
            }
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
