package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.QaEngineer;
import my.project.exceptions.QAEngineerWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class QAEngineerHibernateDao implements Dao<QaEngineer> {
    @Override
    public void create(QaEngineer createQaEngineer) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createQaEngineer);
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
    public void update(QaEngineer updateQaEngineer) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateQaEngineer);
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
            QaEngineer deleteQaEngineer = readById(deleteQAEngineerId);
            try {
                session.delete(deleteQaEngineer);
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
    public List<QaEngineer> readAll() {
        List<QaEngineer> qAEngineerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineerList = session.createQuery("from QAEngineer", QaEngineer.class).list();
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
    public QaEngineer readById(BigInteger readQAEngineerId) {
        QaEngineer qAEngineer;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineer = session.get(QaEngineer.class, readQAEngineerId);
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
    public List<QaEngineer> readAllByParameterAndValues(String parameter, String values) {
        List<QaEngineer> qAEngineerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM QAEngineer qAEngineer WHERE qAEngineer." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineerList = session.createQuery(sql, QaEngineer.class).list();
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
    public List<QaEngineer> readAllByHqlQuery(String sql) {
        List<QaEngineer> qAEngineerList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                qAEngineerList = session.createQuery(sql, QaEngineer.class).list();
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
