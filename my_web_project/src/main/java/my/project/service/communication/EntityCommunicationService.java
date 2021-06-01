package my.project.service.communication;

import my.project.entity.Positions;
import my.project.service.communication.EmployeeDeveloperCommunicationService;
import my.project.service.communication.EmployeeManagerCommunicationService;
import my.project.service.communication.EmployeeQAEngineerCommunicationService;
import my.project.service.entity.DeveloperService;
import my.project.service.entity.ManagerService;
import my.project.service.entity.QAEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EntityCommunicationService {

    @Autowired
    EmployeeManagerCommunicationService employeeManagerCommunicationService;

    @Autowired
    EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService;

    @Autowired
    EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService;

    public EntityCommunicationService() {

    }

    public void createEntityCommunication(BigInteger employeeIdFkParam, String employeePositionParam, String departmentParam, String experienceParam) {
        if (employeePositionParam.equals(Positions.MANAGER.getPosition())) {
            BigInteger managerIdFk = new ManagerService().createManager(departmentParam, experienceParam);
            employeeManagerCommunicationService.createCommunication(employeeIdFkParam, managerIdFk);
        } else if (employeePositionParam.equals(Positions.DEVELOPER.getPosition())) {
            BigInteger developerIdFk = new DeveloperService().createDeveloper(departmentParam, experienceParam);
            employeeDeveloperCommunicationService.createCommunication(employeeIdFkParam, developerIdFk);
        } else if (employeePositionParam.equals(Positions.QA_ENGINEER.getPosition())) {
            BigInteger qAEngineerIdFk = new QAEngineerService().createQAEngineer(departmentParam, experienceParam);
            employeeQAEngineerCommunicationService.createCommunication(employeeIdFkParam, qAEngineerIdFk);
        }
    }
}
