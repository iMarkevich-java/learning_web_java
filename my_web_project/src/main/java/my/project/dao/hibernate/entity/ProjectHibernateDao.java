package my.project.dao.hibernate.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.HibernateSessionInitialized;
import my.project.entity.Project;
import my.project.exceptions.ProjectWebException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

public class ProjectHibernateDao implements Dao<Project> {

    @Override
    public void create(Project createProject) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(createProject);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
    }

    @Override
    public void update(Project updateProject) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(updateProject);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
    }

    @Override
    public void delete(BigInteger deleteProjectId) {
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Project deleteProject = readById(deleteProjectId);
            try {
                session.delete(deleteProject);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
    }

    @Override
    public List<Project> readAll() {
        List<Project> projectList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                projectList = session.createQuery("from Project", Project.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
        return projectList;
    }

    @Override
    public Project readById(BigInteger projectId) {
        Project project;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                project = session.get(Project.class, projectId);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
        return project;
    }

    @Override
    public List<Project> readAllByParameterAndValues(String parameter, String values) {
        List<Project> projectList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            String sql = "FROM Project project WHERE project." + parameter + "='" + values + "'";
            Transaction transaction = session.beginTransaction();
            try {
                projectList = session.createQuery(sql, Project.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
        return projectList;
    }

    @Override
    public List<Project> readAllByHqlQuery(String sql) {
        List<Project> projectList;
        try (Session session = HibernateSessionInitialized.getHibernateSessionInitialized()
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                projectList = session.createQuery(sql, Project.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                String message = e.getMessage();
                throw new ProjectWebException(message);
            }
        } catch (HibernateException e) {
            String message = e.getMessage();
            throw new ProjectWebException(message);
        }
        return projectList;
    }
}
