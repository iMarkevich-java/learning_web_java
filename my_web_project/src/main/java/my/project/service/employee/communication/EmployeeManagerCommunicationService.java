package my.project.service.employee.communication;

import my.project.dao.hibernate.communication.EmployeeManagerCommunicationHibernateDao;
import my.project.dao.repository.EmployeeManagerCommunicationRepositoryDao;
import my.project.entity.EmployeeManagerCommunication;
import my.project.exceptions.CompanyWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class EmployeeManagerCommunicationService {

    private final EmployeeManagerCommunicationHibernateDao dao;
    @Autowired
    EmployeeManagerCommunicationRepositoryDao employeeManagerCommunicationRepositoryDao;

    public EmployeeManagerCommunicationService() {
        this.dao = new EmployeeManagerCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFkParam, BigInteger managerIdFkParam) {
        checkAllParameterOnException(employeeIdFkParam, managerIdFkParam);
        EmployeeManagerCommunication employeeManagerCommunication = new EmployeeManagerCommunication(employeeIdFkParam, managerIdFkParam);
//        dao.create(employeeManagerCommunication);
        employeeManagerCommunicationRepositoryDao.create(employeeManagerCommunication);
        return employeeManagerCommunication.getEmployeeManagerId();
    }

    public BigInteger updateCommunication(BigInteger updateEmployeeIdFkParam, BigInteger updateManagerIdFkParam) {
        checkAllParameterOnException(updateEmployeeIdFkParam, updateManagerIdFkParam);
        EmployeeManagerCommunication employeeManagerCommunication = new EmployeeManagerCommunication(updateEmployeeIdFkParam, updateManagerIdFkParam);
//        dao.create(employeeManagerCommunication);
        employeeManagerCommunicationRepositoryDao.update(employeeManagerCommunication);
        return employeeManagerCommunication.getEmployeeManagerId();
    }

    public void deleteCommunicationByEmployeeId(BigInteger employeeIdFk) {
        employeeManagerCommunicationRepositoryDao.delete(employeeIdFk);
    }

    private void checkAllParameterOnException(BigInteger employeeIdFk, BigInteger managerIdFk) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeIdFk == null) {
            String errorMessage = "Employee fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (managerIdFk == null) {
            String errorMessage = "Developer fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new CompanyWebException(errorList);
        }
    }
}
