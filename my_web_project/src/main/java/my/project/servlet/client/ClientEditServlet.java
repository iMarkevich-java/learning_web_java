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

@WebServlet("/edit-client")
public class ClientEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientIdParam = req.getParameter("editClientIdParam");
        String clientNameParam = req.getParameter("editClientNameParam");
        String clientProjectNameParam = req.getParameter("editClientProjectNameParam");
        String clientAddressParam = req.getParameter("editClientAddressParam");

        req.setAttribute("clientIdParam", clientIdParam);
        req.setAttribute("clientNameParam", clientNameParam);
        req.setAttribute("clientProjectNameParam", clientProjectNameParam);
        req.setAttribute("clientAddressParam", clientAddressParam);
        req.getRequestDispatcher("/pages/client/edit/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateClientIdParam = req.getParameter("updateClientIdParam");
        String updateClientNameParam = req.getParameter("updateClientNameParam");
        String updateClientProjectNameParam = req.getParameter("updateClientProjectNameParam");
        String updateClientAddressParam = req.getParameter("updateClientAddressParam");

        try {
            new ClientService().updateClientById(updateClientIdParam, updateClientNameParam, updateClientProjectNameParam, updateClientAddressParam);
            req.getRequestDispatcher("/clients").forward(req, resp);
        } catch (ClientWebException e) {
            e.printStackTrace();
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.setAttribute("clientIdParam", updateClientIdParam);
            req.setAttribute("clientNameParam", updateClientNameParam);
            req.setAttribute("clientProjectNameParam", updateClientProjectNameParam);
            req.setAttribute("clientAddressParam", updateClientAddressParam);
            req.getRequestDispatcher("/pages/client/edit/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
