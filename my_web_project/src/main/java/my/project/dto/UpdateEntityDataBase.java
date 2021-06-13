package my.project.dto;

import my.project.entity.Developer;
import my.project.entity.Employee;
import my.project.entity.Manager;
import my.project.entity.QaEngineer;
import my.project.service.communication.EmployeeDeveloperCommunicationService;
import my.project.service.communication.EmployeeManagerCommunicationService;
import my.project.service.communication.EmployeeQAEngineerCommunicationService;
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

    @Autowired
    private EmployeeManagerCommunicationService employeeManagerCommunicationService;

    @Autowired
    private EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService;

    @Autowired
    private EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService;

    public UpdateEntityDataBase() {
    }

    public void update(WebParamToEntityDataBase webParamToEntityDataBase) {
        employeeService.updateEmployee(webParamToEntityDataBase.readUpdateEmployee());
        addressService.updateAddress(webParamToEntityDataBase.readUpdateAddress());

        Employee employee = employeeService.readEmployeeById(webParamToEntityDataBase.readUpdateEmployee().getEmployeeId());
        BigInteger employeeId = employee.getEmployeeId();
        String updateDepartmentParam = webParamToEntityDataBase.getUpdateDepartmentParam();
        int updateExperienceParam = webParamToEntityDataBase.getUpdateExperienceParam();

        if (webParamToEntityDataBase.getUpdateEmployeePositionParam().equals("Manager")) {
            if (employee.getManager() == null) {
                if (employee.getDeveloper() != null) {
                    developerService.deleteDeveloperById(employee.getDeveloper().getDeveloperId());
                }
                if (employee.getQaEngineer() != null) {
                    qaEngineerService.deleteQAEngineerById(employee.getQaEngineer().getqAEngineerId());
                }
                BigInteger createManagerId = managerService.createManager(updateDepartmentParam, updateExperienceParam);
                employeeManagerCommunicationService.createCommunication(employeeId, createManagerId);
            } else {
                Manager manager = employee.getManager();
                manager.setManagerDepartment(updateDepartmentParam);
                manager.setManagerExperience(updateExperienceParam);
                managerService.updateManager(manager);
            }
        }
        if (webParamToEntityDataBase.getUpdateEmployeePositionParam().equals("Developer")) {
            if (employee.getDeveloper() == null) {
                if (employee.getManager() != null) {
                    managerService.deleteManagerById(employee.getManager().getManagerId());
                }
                if (employee.getQaEngineer() != null) {
                    qaEngineerService.deleteQAEngineerById(employee.getQaEngineer().getqAEngineerId());
                }
                BigInteger createDeveloperId = developerService.createDeveloper(updateDepartmentParam, updateExperienceParam);
                employeeDeveloperCommunicationService.createCommunication(employeeId, createDeveloperId);
            } else {
                Developer developer = employee.getDeveloper();
                developer.setDeveloperDepartment(updateDepartmentParam);
                developer.setDeveloperExperience(updateExperienceParam);
                developerService.updateDeveloper(developer);
            }
        }
        if (webParamToEntityDataBase.getUpdateEmployeePositionParam().equals("QA engineer")) {
            if (employee.getQaEngineer() == null) {
                if (employee.getManager() != null) {
                    managerService.deleteManagerById(employee.getManager().getManagerId());
                }
                if (employee.getDeveloper() != null) {
                    developerService.deleteDeveloperById(employee.getDeveloper().getDeveloperId());
                }
                BigInteger qaEngineerId = qaEngineerService.createQAEngineer(updateDepartmentParam, updateExperienceParam);
                employeeQAEngineerCommunicationService.createCommunication(employeeId, qaEngineerId);
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
}
