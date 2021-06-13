package my.project.service.communication;

import my.project.dao.hibernate.communication.EmployeeDeveloperCommunicationHibernateDao;
import my.project.dao.repository.EmployeeDeveloperCommunicationRepositoryDao;
import my.project.entity.EmployeeDeveloperCommunication;
import my.project.exceptions.CompanyWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class EmployeeDeveloperCommunicationService {

    private final EmployeeDeveloperCommunicationHibernateDao dao;
    @Autowired
    EmployeeDeveloperCommunicationRepositoryDao employeeDeveloperCommunicationRepositoryDao;

    public EmployeeDeveloperCommunicationService() {
        this.dao = new EmployeeDeveloperCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFkParam, BigInteger developerIdFkParam) {
        checkAllParameterOnException(employeeIdFkParam, developerIdFkParam);
        EmployeeDeveloperCommunication employeeDeveloperCommunication = new EmployeeDeveloperCommunication(employeeIdFkParam, developerIdFkParam);
//        dao.create(employeeDeveloperCommunication);
        employeeDeveloperCommunicationRepositoryDao.create(employeeDeveloperCommunication);
        return employeeDeveloperCommunication.getEmployeeDeveloperId();
    }

    public void updateCommunication(BigInteger updateEmployeeIdFkParam, BigInteger updateDeveloperIdFkParam) {
        checkAllParameterOnException(updateEmployeeIdFkParam, updateDeveloperIdFkParam);
        EmployeeDeveloperCommunication employeeDeveloperCommunication = new EmployeeDeveloperCommunication(updateEmployeeIdFkParam, updateDeveloperIdFkParam);
//        dao.update(employeeDeveloperCommunication);
        employeeDeveloperCommunicationRepositoryDao.update(employeeDeveloperCommunication);
    }

    public void deleteCommunicationByEmployeeId(BigInteger employeeIdFk) {
        employeeDeveloperCommunicationRepositoryDao.delete(employeeIdFk);
    }

    private void checkAllParameterOnException(BigInteger employeeIdFk, BigInteger developerIdFkParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeIdFk == null) {
            String errorMessage = "Employee fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (developerIdFkParam == null) {
            String errorMessage = "Developer fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new CompanyWebException(errorList);
        }
    }
}
