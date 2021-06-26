package my.project.servlet.client;

import my.project.service.clients.entity.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-client")
public class ClientDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteClientIdParam = req.getParameter("deleteClientIdParam");
        new ClientService().deleteClientById(deleteClientIdParam);
        req.getRequestDispatcher("/clients").forward(req, resp);
    }
}
