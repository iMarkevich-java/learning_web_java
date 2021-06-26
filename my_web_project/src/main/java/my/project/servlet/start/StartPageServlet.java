package my.project.servlet.start;

import my.project.entity.Client;
import my.project.service.clients.entity.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/start")

public class StartPageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clientsList = new ClientService().readAllClient();
        req.setAttribute("clientsList", clientsList);
//        String contextPath = req.getContextPath();
        req.getRequestDispatcher("/pages/start/index.jsp").forward(req, resp);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
