package my.project.dao.hibernate.communication;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.EmployeeQAEngineerCommunication;
import my.project.exceptions.EmployeeQAEngineerCommunicationHibernateWbException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class EmployeeQAEngineerCommunicationHibernateDao implements Dao<EmployeeQAEngineerCommunication> {

    @Override
    public void create(EmployeeQAEngineerCommunication employeeQAEngineerCommunication) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(employeeQAEngineerCommunication);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeQAEngineerCommunicationHibernateWbException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeQAEngineerCommunicationHibernateWbException(message);
        }
    }

    @Override
    public void update(EmployeeQAEngineerCommunication employeeQAEngineerCommunication) {

    }

    @Override
    public void delete(BigInteger id) {

    }

    @Override
    public List<EmployeeQAEngineerCommunication> readAll() {
        return null;
    }

    @Override
    public EmployeeQAEngineerCommunication readById(BigInteger id) {
        return null;
    }

    @Override
    public List<EmployeeQAEngineerCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeQAEngineerCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
