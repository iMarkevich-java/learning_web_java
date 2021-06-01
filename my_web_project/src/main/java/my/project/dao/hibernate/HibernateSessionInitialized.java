package my.project.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionInitialized {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static volatile HibernateSessionInitialized hibernateSessionInitialized;

    private HibernateSessionInitialized() {
    }

    public static HibernateSessionInitialized getHibernateSessionInitialized() {
        HibernateSessionInitialized localInstance = hibernateSessionInitialized;
        if (localInstance == null) {
            synchronized (HibernateSessionInitialized.class) {
                localInstance = hibernateSessionInitialized;
                if (localInstance == null) {
                    hibernateSessionInitialized = localInstance = new HibernateSessionInitialized();
                }
            }
        }
        return localInstance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

