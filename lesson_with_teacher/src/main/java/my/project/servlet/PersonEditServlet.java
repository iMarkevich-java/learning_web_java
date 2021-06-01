package my.project.servlet;

import my.project.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/edit")
public class PersonEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdParam = req.getParameter("editIdParam");
        String personNameParam = req.getParameter("editNameParam");
        String personAgeParam = req.getParameter("editAgeParam");

        req.setAttribute("personIdParam", personIdParam);
        req.setAttribute("personNameParam", personNameParam);
        req.setAttribute("personAgeParam", personAgeParam);
        req.getRequestDispatcher("/pages/personEditPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updatedPersonIdParam = req.getParameter("updatedPersonIdParam");
        String updatedPersonNameParam = req.getParameter("updatedPersonNameParam");
        String updatedPersonAgeParam = req.getParameter("updatedPersonAgeParam");

        new PersonService().updatePersonById(updatedPersonIdParam, updatedPersonNameParam, updatedPersonAgeParam);

        req.getRequestDispatcher("/person/list").forward(req, resp);

    }
}
