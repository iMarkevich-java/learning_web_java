package my.project.dto;

import my.project.entity.*;
import my.project.service.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

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

    public UpdateEntityDataBase() {
    }

    public void update(UpdateWebParamToEntityDataBase updateWebParamToEntityDataBase) {
        employeeService.updateEmployee(updateWebParamToEntityDataBase.readUpdateEmployee());
        addressService.updateAddress(updateWebParamToEntityDataBase.readUpdateAddress());

        Employee employee = employeeService.readEmployeeById(updateWebParamToEntityDataBase.readUpdateEmployee().getEmployeeId());
        BigInteger employeeId = employee.getEmployeeId();
        String updateDepartmentParam = updateWebParamToEntityDataBase.getUpdateDepartmentParam();
        int updateExperienceParam = updateWebParamToEntityDataBase.getUpdateExperienceParam();

        if (updateWebParamToEntityDataBase.getUpdateEmployeePositionParam().equals(Positions.MANAGER.getPosition())) {
            if (employee.getManager() == null) {
                if (employee.getDeveloper() != null) {
                    developerService.deleteDeveloperByIdWithCommunication(employee.getDeveloper().getDeveloperId(), employeeId);
                }
                if (employee.getQaEngineer() != null) {
                    qaEngineerService.deleteQaEngineerByIdWithCommunication(employee.getQaEngineer().getQaEngineerId(), employeeId);
                }
                managerService.createManager(updateWebParamToEntityDataBase.readUpdateManager(), employeeId);
            } else {
                Manager manager = employee.getManager();
                manager.setManagerDepartment(updateDepartmentParam);
                manager.setManagerExperience(updateExperienceParam);
                managerService.updateManager(manager);
            }
        }
        if (updateWebParamToEntityDataBase.getUpdateEmployeePositionParam().equals(Positions.DEVELOPER.getPosition())) {
            if (employee.getDeveloper() == null) {
                if (employee.getManager() != null) {
                    managerService.deleteManagerByIdWithCommunication(employee.getManager().getManagerId(), employeeId);
                }
                if (employee.getQaEngineer() != null) {
                    qaEngineerService.deleteQaEngineerByIdWithCommunication(employee.getQaEngineer().getQaEngineerId(), employeeId);
                }
                developerService.createDeveloper(updateWebParamToEntityDataBase.readUpdateDeveloper(), employeeId);
            } else {
                Developer developer = employee.getDeveloper();
                developer.setDeveloperDepartment(updateDepartmentParam);
                developer.setDeveloperExperience(updateExperienceParam);
                developerService.updateDeveloper(developer);
            }
        }
        if (updateWebParamToEntityDataBase.getUpdateEmployeePositionParam().equals(Positions.QA_ENGINEER.getPosition())) {
            if (employee.getQaEngineer() == null) {
                if (employee.getManager() != null) {
                    managerService.deleteManagerByIdWithCommunication(employee.getManager().getManagerId(), employeeId);
                }
                if (employee.getDeveloper() != null) {
                    developerService.deleteDeveloperByIdWithCommunication(employee.getDeveloper().getDeveloperId(), employeeId);
                }
                qaEngineerService.createQAEngineer(updateWebParamToEntityDataBase.readUpdateQaEngineer(), employeeId);
            } else {
                QaEngineer qaEngineer = employee.getQaEngineer();
                qaEngineer.setQaEngineerDepartment(updateDepartmentParam);
                qaEngineer.setQaEngineerExperience(updateExperienceParam);
                qaEngineerService.updateQAEngineer(qaEngineer);
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
