package my.project.dao.hibernate.communication;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.EmployeeDeveloperCommunication;
import my.project.exceptions.AddressWebException;
import my.project.exceptions.EmployeeDeveloperCommunicationHibernateWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class EmployeeDeveloperCommunicationHibernateDao implements Dao<EmployeeDeveloperCommunication> {
    @Override
    public void create(EmployeeDeveloperCommunication employeeDeveloperCommunication) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(employeeDeveloperCommunication);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeDeveloperCommunicationHibernateWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeDeveloperCommunicationHibernateWebException(message);
        }
    }

    @Override
    public void update(EmployeeDeveloperCommunication employeeDeveloperCommunication) {

    }

    @Override
    public void delete(BigInteger id) {

    }

    @Override
    public List<EmployeeDeveloperCommunication> readAll() {
        return null;
    }

    @Override
    public EmployeeDeveloperCommunication readById(BigInteger id) {
        return null;
    }

    @Override
    public List<EmployeeDeveloperCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeDeveloperCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
