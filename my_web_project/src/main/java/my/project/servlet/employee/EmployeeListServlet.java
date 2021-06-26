package my.project.servlet.employee;

import my.project.entity.Employee;
import my.project.service.employee.entity.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList = new EmployeeService().readAllEmployee();
        req.setAttribute("employeesList", employeeList);
        req.getRequestDispatcher("/pages/employee/employees/index.jsp").forward(req, resp);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
