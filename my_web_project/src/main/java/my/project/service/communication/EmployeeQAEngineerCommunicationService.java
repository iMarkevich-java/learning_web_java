package my.project.service.communication;

import my.project.dao.hibernate.communication.EmployeeQAEngineerCommunicationHibernateDao;
import my.project.dao.repository.EmployeeQAEngineerCommunicationRepositoryDao;
import my.project.entity.EmployeeQAEngineerCommunication;
import my.project.exceptions.CompanyWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class EmployeeQAEngineerCommunicationService {

    @Autowired
    EmployeeQAEngineerCommunicationRepositoryDao employeeQAEngineerCommunicationRepositoryDao;

    private final EmployeeQAEngineerCommunicationHibernateDao dao;

    public EmployeeQAEngineerCommunicationService() {
        this.dao = new EmployeeQAEngineerCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFkParam, BigInteger qAEngineerIdFkParam) {
        checkAllParameterOnException(employeeIdFkParam, qAEngineerIdFkParam);
        EmployeeQAEngineerCommunication employeeQAEngineerCommunication = new EmployeeQAEngineerCommunication(employeeIdFkParam, qAEngineerIdFkParam);
//        dao.create(employeeQAEngineerCommunication);
        employeeQAEngineerCommunicationRepositoryDao.create(employeeQAEngineerCommunication);
        return employeeQAEngineerCommunication.getEmployeeQAEngineerId();
    }

    public BigInteger updateCommunication(BigInteger updateEmployeeIdFkParam, BigInteger updateQAEngineerIdFkParam) {
        checkAllParameterOnException(updateEmployeeIdFkParam, updateQAEngineerIdFkParam);
        EmployeeQAEngineerCommunication employeeQAEngineerCommunication = new EmployeeQAEngineerCommunication(updateEmployeeIdFkParam, updateQAEngineerIdFkParam);
//        dao.create(employeeQAEngineerCommunication);
        employeeQAEngineerCommunicationRepositoryDao.update(employeeQAEngineerCommunication);
        return employeeQAEngineerCommunication.getEmployeeQAEngineerId();
    }

    private void checkAllParameterOnException(BigInteger employeeIdFk, BigInteger qAEngineerIdFk) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeIdFk == null) {
            String errorMessage = "Employee fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (qAEngineerIdFk == null) {
            String errorMessage = "QAEngineer fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new CompanyWebException(errorList);
        }
    }
}
