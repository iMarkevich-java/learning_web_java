package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;


public class EmployeeHibernateDao implements Dao<Employee> {

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(employee);
                transaction.commit();
            } catch (EmployeeWebException e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
    }

    @Override
    public void update(Employee updateEmployee) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateEmployee);
                transaction.commit();
            } catch (EmployeeWebException e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteEmployeeId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee deleteEmployee = readById(deleteEmployeeId);
            try {
                session.delete(deleteEmployee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employeeList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                employeeList = session.createQuery("from Employee", Employee.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
        return employeeList;
    }

    @Override
    public Employee readById(BigInteger employeeId) {
        Employee employee;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                employee = session.get(Employee.class, employeeId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
        return employee;
    }

    @Override
    public List<Employee> readAllByParameterAndValues(String parameter, String values) {
        List<Employee> employeeList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Employee employee WHERE employee." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                employeeList = session.createQuery(sql, Employee.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
        return employeeList;
    }

    @Override
    public List<Employee> readAllByHqlQuery(String sql) {
        List<Employee> employeeList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                employeeList = session.createQuery(sql, Employee.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new EmployeeWebException(message);

            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new EmployeeWebException(message);
        }
        return employeeList;
    }
}
