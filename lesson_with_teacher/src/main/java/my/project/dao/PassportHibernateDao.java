package my.project.dao;

import my.project.entity.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PassportHibernateDao {

    static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//    public static void main(String[] args) {
//        List<Passport> passports = new PassportHibernateDao().readAllPassports();
//        System.out.println();
//    }

    public  List<Passport> readAllPassports() {
        Session session = sessionFactory.openSession();
        List<Passport> passportList = session.createQuery("from Passport", Passport.class).list();
        return passportList;
    }
}
