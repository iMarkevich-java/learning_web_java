package my.project.service;

import my.project.dao.PersonDao;
import my.project.dao.PersonHibernateDao;
import my.project.entity.Person;
import my.project.exceptions.PersonWebException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonDao personDao;

    public PersonService() {
//        personDao = new PersonJdbcDao();
        personDao = new PersonHibernateDao();
    }

    public void createPerson(String personIdParam, String personNameParam, String personAgeParam) throws PersonWebException {
        ArrayList<String> errorList = new ArrayList<>();
        if (personIdParam == null || personIdParam.length() == 0) {
            String errorMessage = "personId can't be empty";
            errorList.add(errorMessage);
            if (personIdParam == null || personIdParam.length() == 0) {
                errorMessage = "personId can't be empty";
                errorList.add(errorMessage);
                throw new PersonWebException(errorList);
            }
        }

        int personAge = Integer.parseInt(personAgeParam);

        Person person1 = new Person(personNameParam, personAge);
        personDao.createPerson(person1);
    }

    public void updatePersonById(String updatedPersonIdParam, String updatedPersonNameParam, String updatedPersonAgeParam) {
        int personId = Integer.parseInt(updatedPersonIdParam);
        int personAge = Integer.parseInt(updatedPersonAgeParam);
        personDao.updatePerson(personId, updatedPersonNameParam, personAge);
    }

    public void deletePersonById(String deleteIdParam) {
        int deleteId = Integer.parseInt(deleteIdParam);
        personDao.deletePerson(deleteId);
    }

    public Person readPersonById(int id) {
        Person person = personDao.readPersonById(id);
        return person;
    }

    public List<Person> readAllPerson() {
        List<Person> people = personDao.readAllPersons();
        return people;
    }
}
