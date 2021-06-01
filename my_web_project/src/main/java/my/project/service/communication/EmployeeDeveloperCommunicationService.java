package my.project.service.communication;

import my.project.dao.hibernate.communication.EmployeeDeveloperCommunicationHibernateDao;
import my.project.entity.EmployeeDeveloperCommunication;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EmployeeDeveloperCommunicationService {
    final EmployeeDeveloperCommunicationHibernateDao dao;

    public EmployeeDeveloperCommunicationService() {
        this.dao = new EmployeeDeveloperCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFk, BigInteger developerIdFk) {
        EmployeeDeveloperCommunication employeeDeveloperCommunication = new EmployeeDeveloperCommunication(employeeIdFk, developerIdFk);
        dao.create(employeeDeveloperCommunication);
        return employeeDeveloperCommunication.getEmployeeDeveloperId();
    }
}
