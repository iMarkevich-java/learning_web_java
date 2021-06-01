package my.project.service.communication;

import my.project.dao.hibernate.communication.EmployeeManagerCommunicationHibernateDao;
import my.project.entity.EmployeeManagerCommunication;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EmployeeManagerCommunicationService {
    final EmployeeManagerCommunicationHibernateDao dao;

    public EmployeeManagerCommunicationService() {
        this.dao = new EmployeeManagerCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFk, BigInteger managerIdFk) {
        EmployeeManagerCommunication employeeManagerCommunication = new EmployeeManagerCommunication(employeeIdFk, managerIdFk);
        dao.create(employeeManagerCommunication);
        return employeeManagerCommunication.getEmployeeManagerId();
    }
}
