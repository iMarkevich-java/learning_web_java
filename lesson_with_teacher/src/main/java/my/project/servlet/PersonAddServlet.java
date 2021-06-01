package my.project.servlet;

import my.project.exceptions.PersonWebException;
import my.project.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/person/add")
public class PersonAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/personAddPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdParam = req.getParameter("personIdParam");
        String personNameParam = req.getParameter("personNameParam");
        String personAgeParam = req.getParameter("personAgeParam");


        try {
            new PersonService().createPerson(personIdParam, personNameParam, personAgeParam);
            req.getRequestDispatcher("/person/list").forward(req, resp);
        } catch (PersonWebException e) {
            e.printStackTrace();
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.getRequestDispatcher("/pages/personAddPage.jsp").forward(req, resp);
        } finally {
        }
    }
}
