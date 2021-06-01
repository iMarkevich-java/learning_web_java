package my.project.controller;

import my.project.entity.Person;
import my.project.exceptions.PersonWebException;
import my.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/rest")
public class PersonRestController {

    @Autowired
    PersonService personService;

    @GetMapping("/person/id")
    public Person getPersonById() {
        Person vova = new Person(1, "Vova", 35);
        return vova;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        try {
            personService.readPersonById(10);
        } catch (PersonWebException e) {
            e.printStackTrace();
        }
        bum("nails", 300);
        gym();
        List<Person> personList = new ArrayList<>();
        Person vova = new Person(1, "Vova", 35);
        Person ivan = new Person(2, "ivan", 40);
        Person kola = new Person(3, "kola", 45);
        personList.add(vova);
        personList.add(ivan);
        personList.add(kola);
        return personList;
    }

    public void bum(String word, int age){
        System.out.println();
    }

    public void gym(){
        System.out.println();
    }
}
