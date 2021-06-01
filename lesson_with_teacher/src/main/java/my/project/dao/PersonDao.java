package my.project.dao;

import my.project.entity.Person;

import java.util.List;

public interface PersonDao {

    void createPerson(int id, String name, int age);

    void createPerson(Person person);

    void updatePerson(int id, String updateName, int updateAge);

    void deletePerson(int id);

    List<Person> readAllPersons();

    Person readPersonById(int id);

}
