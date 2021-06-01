package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Company;
import my.project.exceptions.CompanyWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class CompanyHibernateDao implements Dao<Company> {

    @Override
    public void create(Company createCompany) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createCompany);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
    }

    @Override
    public void update(Company updateCompany) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateCompany);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteCompanyId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Company deleteCompany = readById(deleteCompanyId);
            try {
                session.delete(deleteCompany);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
    }

    @Override
    public List<Company> readAll() {
        List<Company> companyList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                companyList = session.createQuery("from Company", Company.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
        return companyList;
    }

    @Override
    public Company readById(BigInteger readCompanyId) {
        Company company;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                company = session.get(Company.class, readCompanyId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
        return company;
    }

    @Override
    public List<Company> readAllByParameterAndValues(String parameter, String values) {
        List<Company> companyList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Company company WHERE company." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                companyList = session.createQuery(sql, Company.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
        return companyList;
    }

    @Override
    public List<Company> readAllByHqlQuery(String sql) {
        List<Company> companyList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                companyList = session.createQuery(sql, Company.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new CompanyWebException(message);

            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new CompanyWebException(message);
        }
        return companyList;
    }


}
