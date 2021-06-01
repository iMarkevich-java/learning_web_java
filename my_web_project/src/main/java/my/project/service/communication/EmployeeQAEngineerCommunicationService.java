package my.project.service.communication;

import my.project.dao.hibernate.communication.EmployeeQAEngineerCommunicationHibernateDao;
import my.project.entity.EmployeeQAEngineerCommunication;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EmployeeQAEngineerCommunicationService {
    final EmployeeQAEngineerCommunicationHibernateDao dao;

    public EmployeeQAEngineerCommunicationService() {
        this.dao = new EmployeeQAEngineerCommunicationHibernateDao();
    }

    public BigInteger createCommunication(BigInteger employeeIdFk, BigInteger qAEngineerIdFk) {
        EmployeeQAEngineerCommunication employeeQAEngineerCommunication = new EmployeeQAEngineerCommunication(employeeIdFk, qAEngineerIdFk);
        dao.create(employeeQAEngineerCommunication);
        return employeeQAEngineerCommunication.getEmployeeQAEngineerId();
    }
}
