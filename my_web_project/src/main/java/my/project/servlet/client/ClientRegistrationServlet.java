package my.project.servlet.client;

import my.project.exceptions.ClientWebException;
import my.project.service.clients.entity.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration-client")
public class ClientRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/client/registration/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String clientNameParam = req.getParameter("clientNameParam");
        String clientNameProjectParam = req.getParameter("clientNameProjectParam");
        String clientAddressParam = req.getParameter("clientAddressParam");

        try {
            new ClientService().createClient(clientNameParam, clientNameProjectParam, clientAddressParam);
            req.getRequestDispatcher("/clients").forward(req, resp);
        } catch (ClientWebException e) {
            e.printStackTrace();
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.getRequestDispatcher("/pages/client/registration/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
