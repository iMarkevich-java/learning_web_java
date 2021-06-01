package my.project.dao.hibernate.communication;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.EmployeeManagerCommunication;
import my.project.exceptions.EmployeeManagerCommunicationHibernateWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class EmployeeManagerCommunicationHibernateDao implements Dao<EmployeeManagerCommunication> {

    @Override
    public void create(EmployeeManagerCommunication employeeManagerCommunication) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(employeeManagerCommunication);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeManagerCommunicationHibernateWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeManagerCommunicationHibernateWebException(message);
        }
    }

    @Override
    public void update(EmployeeManagerCommunication employeeManagerCommunication) {

    }

    @Override
    public void delete(BigInteger id) {

    }

    @Override
    public List<EmployeeManagerCommunication> readAll() {
        return null;
    }

    @Override
    public EmployeeManagerCommunication readById(BigInteger id) {
        return null;
    }

    @Override
    public List<EmployeeManagerCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeManagerCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
