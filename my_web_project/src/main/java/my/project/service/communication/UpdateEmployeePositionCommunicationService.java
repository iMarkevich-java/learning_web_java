package my.project.service.communication;

import my.project.entity.Employee;
import my.project.entity.Positions;
import my.project.service.entity.DeveloperService;
import my.project.service.entity.EmployeeService;
import my.project.service.entity.ManagerService;
import my.project.service.entity.QAEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UpdateEmployeePositionCommunicationService {

    @Autowired
    EmployeeService employeeService;

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

    public UpdateEmployeePositionCommunicationService() {

    }

    public void updateEntityCommunication(String employeeIdFkParam, String employeePositionParam, String departmentParam, String experienceParam) {
        BigInteger employeeIdFk = new BigInteger(employeeIdFkParam);
        if (employeePositionParam.equals(Positions.MANAGER.getPosition())) {
            Employee employee = employeeService.readEmployeeById(employeeIdFkParam);
            managerService.updateManagerById(employee.getManager().getManagerId().toString(), departmentParam, experienceParam);
//            employeeManagerCommunicationService.updateCommunication(employeeIdFk, employee.getManager().getManagerId());
        } else if (employeePositionParam.equals(Positions.DEVELOPER.getPosition())) {
            Employee employee = employeeService.readEmployeeById(employeeIdFkParam);
            developerService.updateDeveloperById(employee.getDeveloper().getDeveloperId().toString(), departmentParam, experienceParam);
            employeeDeveloperCommunicationService.updateCommunication(employeeIdFk, employee.getDeveloper().getDeveloperId());
        } else if (employeePositionParam.equals(Positions.QA_ENGINEER.getPosition())) {
            Employee employee = employeeService.readEmployeeById(employeeIdFkParam);
            qaEngineerService.updateQAEngineerById(employee.getQaEngineer().getqAEngineerId().toString(), departmentParam, experienceParam);
            employeeQAEngineerCommunicationService.updateCommunication(employeeIdFk, employee.getQaEngineer().getqAEngineerId());
        }
    }
}
