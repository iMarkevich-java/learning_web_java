package my.project.dao.hibernate.communication;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.EmployeeDeveloperCommunication;
import my.project.exceptions.EmployeeWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class EntityCommunicationDao implements Dao<EmployeeDeveloperCommunication> {

    @Override
    public void create(EmployeeDeveloperCommunication employeeDeveloperCommunication) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.save(employeeDeveloperCommunication);
                transaction.commit();
            } catch (EmployeeWebException e) {
                transaction.rollback();
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
    }

    @Override
    public void update(EmployeeDeveloperCommunication employeeDeveloperCommunication) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(employeeDeveloperCommunication);
                transaction.commit();
            } catch (EmployeeWebException e) {
                transaction.rollback();
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
    }

    @Override
    public void delete(BigInteger id) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            EmployeeDeveloperCommunication employeeDeveloperCommunication = readById(id);
            try {
                session.delete(employeeDeveloperCommunication);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
    }

    @Override
    public List<EmployeeDeveloperCommunication> readAll() {
        List<EmployeeDeveloperCommunication> employeeDeveloperCommunicationList = null;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                employeeDeveloperCommunicationList = session.createQuery("from EmployeeAddressCommunication", EmployeeDeveloperCommunication.class).list();
                transaction.commit();
            } catch (Exception e) {
                String message = e.getMessage();
                transaction.rollback();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            new EmployeeWebException(message);
        }
        return employeeDeveloperCommunicationList;
    }

    @Override
    public EmployeeDeveloperCommunication readById(BigInteger id) {
        EmployeeDeveloperCommunication employeeDeveloperCommunication = null;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                employeeDeveloperCommunication = session.get(EmployeeDeveloperCommunication.class, id);
                transaction.commit();
            } catch (Exception e) {
                String message = e.getMessage();
                new EmployeeWebException(message);
                transaction.rollback();
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            new EmployeeWebException(message);
        }
        return employeeDeveloperCommunication;
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
