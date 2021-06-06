package my.project.dao.hibernate.communication;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.EmployeeAddressCommunication;
import my.project.exceptions.EmployeeAddressCommunicationHibernateWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class EmployeeAddressCommunicationHibernateDao implements Dao<EmployeeAddressCommunication> {


    @Override
    public void create(EmployeeAddressCommunication employeeAddressCommunication) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(employeeAddressCommunication);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeAddressCommunicationHibernateWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeAddressCommunicationHibernateWebException(message);
        }
    }

    @Override
    public void update(EmployeeAddressCommunication employeeAddressCommunication) {

    }

    @Override
    public void delete(BigInteger id) {

    }

    @Override
    public List<EmployeeAddressCommunication> readAll() {
        return null;
    }

    @Override
    public EmployeeAddressCommunication readById(BigInteger id) {

        return null;
    }

    @Override
    public List<EmployeeAddressCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeAddressCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
