package my.project.controller;

import my.project.entity.Person;
import my.project.exceptions.PersonWebException;
import my.project.repository.PersonRepository;
import my.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mvc/person")
public class PersonController {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String methodReturnPersonListPageUsingModel(Model model) {
//        List<Person> people = personService.readAllPerson();
        Iterable<Person> people = personRepo.findAll();
        Optional<Person> byId = personRepo.findById(107);
        List<Person> personByAge = personRepo.findByAge(30);
//        Person person = byId.orElse(new Person());
        Person person = byId.orElseThrow(() -> new PersonWebException(""));
//        List<Person> byNameLikeAndAge = personRepo.findByNameLikeAndAge("%K", 30);
        List<Person> byNameLikeAndAgeBetween = personRepo.findByNameLikeAndAgeBetween("%e%", 20, 60);

        int kirilCount = personRepo.getCountOfPersonsWithName("Kiril");

        List<Person> kiril = personRepo.getWithAgeAndName(30, "Kiril");
        model.addAttribute("personList", people);
        return "personListPage";
    }

    @GetMapping("/list2")
    public ModelAndView methodReturnPersonListPageUsingModelAndView() {
        List<Person> people = personService.readAllPerson();
        ModelAndView mav = new ModelAndView();
        mav.addObject("personList", people);
        mav.setViewName("personListPage");
        return mav;
    }

    @GetMapping("/delete")
    public String deletePersonById(@RequestParam(name = "deleteIdParam") String deleteIdParam) {
        personService.deletePersonById(deleteIdParam);
//        req.getRequestDispatcher("/person/list").forward(req, resp);
        return "forward:/mvc/person/list";
    }

    @GetMapping("/add")
    public String returnPersonAddPage() {
        return "personAddPage";
    }

    @PostMapping("/add")
    public String addNewPerson(@RequestParam(name = "personIdParam") String personIdParam,
                               @RequestParam(name = "personNameParam") String personNameParam,
                               @RequestParam(name = "personAgeParam") String personAgeParam,
                               Model model) {
        try {
            personService.createPerson(personIdParam, personNameParam, personAgeParam);
            return "forward:/mvc/person/list";
        } catch (PersonWebException e) {
            e.printStackTrace();
            List<String> errorList = e.getErrorList();
            model.addAttribute("messageList", errorList);
            return "personAddPage";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String methodReturnPersonListPageUsingModelPost(Model model) {
        List<Person> people = personService.readAllPerson();
        model.addAttribute("personList", people);
        return "personListPage";
    }

    @GetMapping("/edit")
    public String returnPersonEditPage(@RequestParam(name = "editIdParam") String personIdParam,
                                       @RequestParam(name = "editNameParam") String personNameParam,
                                       @RequestParam(name = "editAgeParam") String personAgeParam,
                                       Model model) {

        model.addAttribute("personIdParam", personIdParam);
        model.addAttribute("personNameParam", personNameParam);
        model.addAttribute("personAgeParam", personAgeParam);
        return "personEditPage";
    }

    @PostMapping("/edit")
    public String editPerson(@RequestParam(name = "updatedPersonIdParam") String updatedPersonIdParam,
                             @RequestParam(name = "updatedPersonNameParam") String updatedPersonNameParam,
                             @RequestParam(name = "updatedPersonAgeParam") String updatedPersonAgeParam,
                             Model model) {
        personService.updatePersonById(updatedPersonIdParam, updatedPersonNameParam, updatedPersonAgeParam);
        return "forward:/mvc/person/list";
    }
}
