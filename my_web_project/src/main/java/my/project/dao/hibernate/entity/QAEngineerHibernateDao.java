package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Address;
import my.project.entity.QAEngineer;
import my.project.exceptions.AddressWebException;
import my.project.exceptions.QAEngineerWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class QAEngineerHibernateDao implements Dao<QAEngineer> {
    @Override
    public void create(QAEngineer createQAEngineer) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createQAEngineer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
    }

    @Override
    public void update(QAEngineer updateQAEngineer) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateQAEngineer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteQAEngineerId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            QAEngineer deleteQAEngineer = readById(deleteQAEngineerId);
            try {
                session.delete(deleteQAEngineer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
    }

    @Override
    public List<QAEngineer> readAll() {
        List<QAEngineer> qAEngineerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineerList = session.createQuery("from QAEngineer", QAEngineer.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
        return qAEngineerList;
    }

    @Override
    public QAEngineer readById(BigInteger readQAEngineerId) {
        QAEngineer qAEngineer;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineer = session.get(QAEngineer.class, readQAEngineerId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
        return qAEngineer;
    }

    @Override
    public List<QAEngineer> readAllByParameterAndValues(String parameter, String values) {
        List<QAEngineer> qAEngineerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM QAEngineer qAEngineer WHERE qAEngineer." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineerList = session.createQuery(sql, QAEngineer.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
        return qAEngineerList;
    }

    @Override
    public List<QAEngineer> readAllByHqlQuery(String sql) {
        List<QAEngineer> qAEngineerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineerList = session.createQuery(sql, QAEngineer.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new QAEngineerWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new QAEngineerWebException(message);
        }
        return qAEngineerList;
    }
}
