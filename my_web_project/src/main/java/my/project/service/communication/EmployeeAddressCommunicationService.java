package my.project.service.communication;

import my.project.dao.hibernate.communication.EmployeeAddressCommunicationHibernateDao;
import my.project.entity.EmployeeAddressCommunication;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EmployeeAddressCommunicationService {

    final EmployeeAddressCommunicationHibernateDao dao;

    private Boolean flag = false;

    public EmployeeAddressCommunicationService() {
        this.dao = new EmployeeAddressCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFkParam, BigInteger addressIdFk) {
        EmployeeAddressCommunication employeeAddressCommunication = new EmployeeAddressCommunication(employeeIdFkParam, addressIdFk);
        dao.create(employeeAddressCommunication);
        return employeeAddressCommunication.getEmployeeAddressId();
    }
}
