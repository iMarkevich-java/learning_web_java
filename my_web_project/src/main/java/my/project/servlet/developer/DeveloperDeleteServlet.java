package my.project.servlet.developer;

import my.project.service.employee.entity.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-developer")
public class DeveloperDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteDeveloperIdParam = req.getParameter("deleteDeveloperIdParam");
        new DeveloperService().deleteDeveloperById(deleteDeveloperIdParam);
        req.getRequestDispatcher("/developers").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
