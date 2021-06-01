package my.project.servlet.developer;

import my.project.entity.Developer;
import my.project.service.entity.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/developers")
public class DeveloperListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Developer> developerList = new DeveloperService().readAllDeveloper();
        req.setAttribute("developersList", developerList);
        req.getRequestDispatcher("/pages/developer/developers/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
