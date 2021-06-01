package my.project.servlet;

import my.project.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/delete")
public class PersonDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteIdParam = req.getParameter("deleteIdParam");
        new PersonService().deletePersonById(deleteIdParam);
        req.getRequestDispatcher("/person/list").forward(req, resp);
    }


}
