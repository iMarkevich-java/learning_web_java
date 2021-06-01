package my.project.servlet.employee;

import my.project.service.entity.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-employee")
public class EmployeeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteEmployeeParam = req.getParameter("deleteEmployeeIdParam");
        new EmployeeService().deleteEmployeeById(deleteEmployeeParam);
        req.getRequestDispatcher("/employees").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
