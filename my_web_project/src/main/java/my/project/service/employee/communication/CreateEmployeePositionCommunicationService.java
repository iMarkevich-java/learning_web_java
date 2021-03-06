package my.project.service.employee.communication;

import my.project.entity.Positions;
import my.project.service.employee.entity.DeveloperService;
import my.project.service.employee.entity.ManagerService;
import my.project.service.employee.entity.QAEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CreateEmployeePositionCommunicationService {
    @Autowired
    DeveloperService developerService;

    @Autowired
    QAEngineerService qaEngineerService;

    @Autowired
    ManagerService managerService;

    @Autowired
    EmployeeManagerCommunicationService employeeManagerCommunicationService;

    @Autowired
    EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService;

    @Autowired
    EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService;

    public CreateEmployeePositionCommunicationService() {

    }

    public void createEntityCommunication(BigInteger employeeIdFkParam, String employeePositionParam, String departmentParam, int experienceParam) {
        if (employeePositionParam.equals(Positions.MANAGER.getPosition())) {
            BigInteger managerIdFk = managerService.createManager(departmentParam, experienceParam);
            employeeManagerCommunicationService.createCommunication(employeeIdFkParam, managerIdFk);
        } else if (employeePositionParam.equals(Positions.DEVELOPER.getPosition())) {
            BigInteger developerIdFk = developerService.createDeveloper(departmentParam, experienceParam);
            employeeDeveloperCommunicationService.createCommunication(employeeIdFkParam, developerIdFk);
        } else if (employeePositionParam.equals(Positions.QA_ENGINEER.getPosition())) {
            BigInteger qAEngineerIdFk = qaEngineerService.createQAEngineer(departmentParam, experienceParam);
            employeeQAEngineerCommunicationService.createCommunication(employeeIdFkParam, qAEngineerIdFk);
        }
    }
}
