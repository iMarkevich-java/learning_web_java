package my.project.service.employee.communication;

import my.project.dao.hibernate.communication.EmployeeAddressCommunicationHibernateDao;
import my.project.dao.repository.EmployeeAddressCommunicationRepositoryDao;
import my.project.entity.EmployeeAddressCommunication;
import my.project.exceptions.CompanyWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class EmployeeAddressCommunicationService {

    final EmployeeAddressCommunicationHibernateDao dao;
    @Autowired
    EmployeeAddressCommunicationRepositoryDao employeeAddressCommunicationRepositoryDao;

    public EmployeeAddressCommunicationService() {
        this.dao = new EmployeeAddressCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFkParam, BigInteger addressIdFkParam) {
        checkAllParameterOnException(employeeIdFkParam, addressIdFkParam);
        EmployeeAddressCommunication employeeAddressCommunication = new EmployeeAddressCommunication(employeeIdFkParam, addressIdFkParam);
//        dao.create(employeeAddressCommunication);
        employeeAddressCommunicationRepositoryDao.create(employeeAddressCommunication);
        return employeeAddressCommunication.getEmployeeAddressId();
    }

    public void updateCommunication(BigInteger updateEmployeeIdFkParam, BigInteger updateAddressIdFkParam) {
        checkAllParameterOnException(updateEmployeeIdFkParam, updateAddressIdFkParam);
        EmployeeAddressCommunication employeeAddressCommunication = new EmployeeAddressCommunication(updateEmployeeIdFkParam, updateAddressIdFkParam);
//        dao.update(employeeAddressCommunication);
        employeeAddressCommunicationRepositoryDao.update(employeeAddressCommunication);
    }

    public void deleteCommunication(BigInteger employeeIdFkParam) {
        employeeAddressCommunicationRepositoryDao.delete(employeeIdFkParam);
    }

    private void checkAllParameterOnException(BigInteger employeeIdFk, BigInteger addressIdFk) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeIdFk == null) {
            String errorMessage = "Employee fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressIdFk == null) {
            String errorMessage = "Address fk id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new CompanyWebException(errorList);
        }
    }
}
