package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Client;
import my.project.exceptions.ClientWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class ClientHibernateDao implements Dao<Client> {

    public void create(Client createClient) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createClient);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
    }

    @Override
    public void update(Client updateClient) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateClient);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteClientId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client deleteClient = readById(deleteClientId);
            try {
                session.delete(deleteClient);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
    }

    @Override
    public List<Client> readAll() {
        List<Client> clientList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                clientList = session.createQuery("from Client", Client.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
        return clientList;
    }

    @Override
    public Client readById(BigInteger clientId) {
        Client client;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                client = session.get(Client.class, clientId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
        return client;
    }

    @Override
    public List<Client> readAllByParameterAndValues(String parameter, String values) {
        List<Client> clientList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Client client WHERE client." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                clientList = session.createQuery(sql, Client.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
        return clientList;
    }

    @Override
    public List<Client> readAllByHqlQuery(String sql) {
        List<Client> clientList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                clientList = session.createQuery(sql, Client.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ClientWebException(message);

            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ClientWebException(message);
        }
        return clientList;
    }
}
