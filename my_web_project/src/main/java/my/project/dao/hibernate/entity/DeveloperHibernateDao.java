package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Developer;
import my.project.exceptions.DeveloperWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class DeveloperHibernateDao implements Dao<Developer> {

    @Override
    public void create(Developer newDeveloper) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.save(newDeveloper);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
    }

    @Override
    public void update(Developer updateDeveloper) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateDeveloper);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteDeveloperId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Developer deleteDeveloper = readById(deleteDeveloperId);
            try {
                session.delete(deleteDeveloper);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
    }

    @Override
    public List<Developer> readAll() {
        List<Developer> developerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                developerList = session.createQuery("from Developer", Developer.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
        return developerList;
    }

    @Override
    public Developer readById(BigInteger readDeveloperId) {
        Developer developer;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                developer = session.get(Developer.class, readDeveloperId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
        return developer;
    }

    @Override
    public List<Developer> readAllByParameterAndValues(String parameter, String values) {
        List<Developer> developerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Developer developer WHERE developer." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                developerList = session.createQuery(sql, Developer.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
        return developerList;
    }

    @Override
    public List<Developer> readAllByHqlQuery(String sql) {
        List<Developer> developerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                developerList = session.createQuery(sql, Developer.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new DeveloperWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new DeveloperWebException(message);
        }
        return developerList;
    }
}
