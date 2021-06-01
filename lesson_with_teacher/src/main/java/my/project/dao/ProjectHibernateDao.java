package my.project.dao;

import my.project.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProjectHibernateDao {
    static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        List<Project> projectList = new ProjectHibernateDao().readAllProject();
        System.out.println();
    }

    public  List<Project> readAllProject() {
        Session session = sessionFactory.openSession();
        List<Project> projectList = session.createQuery("from Project", Project.class).list();
        return projectList;
    }
}
