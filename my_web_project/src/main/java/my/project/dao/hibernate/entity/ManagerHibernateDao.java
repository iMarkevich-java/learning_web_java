package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Manager;
import my.project.exceptions.ManagerWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class ManagerHibernateDao implements Dao<Manager> {

    @Override
    public void create(Manager createManager) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createManager);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
    }

    @Override
    public void update(Manager updateManager) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateManager);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteManagerId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Manager deleteManager = readById(deleteManagerId);
            try {
                session.delete(deleteManager);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
    }

    @Override
    public List<Manager> readAll() {
        List<Manager> managerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                managerList = session.createQuery("from Manager", Manager.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
        return managerList;
    }

    @Override
    public Manager readById(BigInteger readManagerId) {
        Manager manager;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                manager = session.get(Manager.class, readManagerId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
        return manager;
    }

    @Override
    public List<Manager> readAllByParameterAndValues(String parameter, String values) {
        List<Manager> managerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Manager manager WHERE manager." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                managerList = session.createQuery(sql, Manager.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
        return managerList;
    }

    @Override
    public List<Manager> readAllByHqlQuery(String sql) {
        List<Manager> managerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                managerList = session.createQuery(sql, Manager.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ManagerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ManagerWebException(message);
        }
        return managerList;
    }
}
