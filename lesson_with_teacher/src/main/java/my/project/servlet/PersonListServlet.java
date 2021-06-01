package my.project.servlet;

import my.project.entity.Person;
import my.project.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PersonListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.setAttribute("message", "aaaaa");

//        HttpSession session = req.getSession();
//        Object personList = session.getAttribute("personList");
//        if(personList == null){
//            ArrayList<Person> people = new ArrayList<>();
//            people.add(new Person(1, "Vova", 56));
//            people.add(new Person(2, "Ivan", 45));
//            people.add(new Person(3, "Sergej", 78));
//            session.setAttribute("personList", people);
//        }
//        req.setAttribute("message", "value");
//        personList = session.getAttribute("personList");
        List<Person> people = new PersonService().readAllPerson();
        req.setAttribute("personList", people);

        String contextPath = req.getContextPath();
        req.getRequestDispatcher("/pages/personListPage.jsp").forward(req, resp);

//
//        resp.sendRedirect(contextPath + "/pages/personListPage.jsp");
    }
}
