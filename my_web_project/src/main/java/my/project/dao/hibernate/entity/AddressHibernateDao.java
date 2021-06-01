package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Address;
import my.project.exceptions.AddressWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class AddressHibernateDao implements Dao<Address> {

    @Override
    public void create(Address createAddress) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createAddress);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
    }

    @Override
    public void update(Address updateAddress) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateAddress);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteAddressId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Address deleteAddress = readById(deleteAddressId);
            try {
                session.delete(deleteAddress);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
    }

    @Override
    public List<Address> readAll() {
        List<Address> addressList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                addressList = session.createQuery("from Address", Address.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
        return addressList;
    }

    @Override
    public Address readById(BigInteger addressId) {
        Address address;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                address = session.get(Address.class, addressId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
        return address;
    }

    @Override
    public List<Address> readAllByParameterAndValues(String parameter, String values) {
        List<Address> addressList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Address address WHERE address." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                addressList = session.createQuery(sql, Address.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
        return addressList;
    }

    @Override
    public List<Address> readAllByHqlQuery(String sql) {
        List<Address> addressList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                addressList = session.createQuery(sql, Address.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new AddressWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new AddressWebException(message);
        }
        return addressList;
    }


}
