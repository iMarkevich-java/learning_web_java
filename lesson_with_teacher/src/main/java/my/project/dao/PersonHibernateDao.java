package my.project.dao;

import my.project.entity.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import java.util.List;

public class PersonHibernateDao implements PersonDao {

    static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        List<Person> people = new PersonHibernateDao().readAllPersons();
        System.out.println();
//        new PersonHibernateDao().createPerson(new Person("Sergej", 12));
//        new PersonHibernateDao().createPerson(new Person("Ivan", 34));
//        new PersonHibernateDao().createPerson(new Person("Sasa", 56));
//        new PersonHibernateDao().createPerson(new Person("Dima", 67));
//        new PersonHibernateDao().createPerson(new Person("Kolia", 68));
//        new PersonHibernateDao().createPerson(new Person("Kolia", 68));
////        List<Person> people = new PersonHibernateDao().readAllPersonsByName("Ivan");
//        new PersonHibernateDao().getAllPersonsWithNameAndAge("Kolia", 68);
    }

    public PersonHibernateDao() {
    }

    @Override
    public void createPerson(int id, String name, int age) {
        createPerson(new Person(id, name, age));

    }

    @Override
    public void createPerson(Person person) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void updatePerson(int id, String updateName, int updateAge) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person(id, updateName, updateAge);

        try {
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deletePerson(int id) {
        Person person = readPersonById(id);
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<Person> readAllPersons() {
        Session session = sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person", Person.class).list();
        return personList;
    }

    public List<Person> readAllPersonsByName(String name) {
        Session session = sessionFactory.openSession();
        String sql = "SELECT * from person where person.name='" + name + "'";
        List<Person> personList = session.createSQLQuery(sql).list();
        return personList;
    }

    public List<Person> getAllPersonsWithNameAndAge(String name, int age) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Person.class);
        SimpleExpression nameRestriction = Restrictions.like("name", "%");
        SimpleExpression ageRestriction = Restrictions.gt("age", 65);
//        Criterion rest1= Restrictions.and(nameRestriction,
//                Restrictions.in("B", Arrays.asList("X",Y)));
//        Criterion rest2= Restrictions.and(Restrictions.eq(A, "Y"),
//                Restrictions.eq(B, "Z"));
        criteria.add(Restrictions.and(nameRestriction, ageRestriction));
        List<Person> list = criteria.list();
        return list;
    }

    @Override
    public Person readPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Person person = null;
        try {
            person = session.get(Person.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return person;
    }


}
