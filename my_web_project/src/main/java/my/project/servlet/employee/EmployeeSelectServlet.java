package my.project.servlet.employee;

import my.project.entity.Employee;
import my.project.service.entity.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/select-employee")
public class EmployeeSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectEmployeeIdParam = req.getParameter("selectEmployeeIdParam");
        String selectEmployeeFirstNameParam = req.getParameter("selectEmployeeFirstNameParam");
        String selectEmployeeSurnameParam = req.getParameter("selectEmployeeSurnameParam");
        String selectEmployeeDateOfBornParam = req.getParameter("selectEmployeeDateOfBornParam");
        String selectEmployeeAgeParam = req.getParameter("selectEmployeeAgeParam");
        String selectEmployeePositionParam = req.getParameter("selectEmployeePositionParam");
        List<Employee> employeeList = new EmployeeService().readAllEmployeeByParameter(selectEmployeeIdParam, selectEmployeeFirstNameParam, selectEmployeeSurnameParam, selectEmployeeDateOfBornParam, selectEmployeePositionParam);
        req.setAttribute("employeesList", employeeList);
        req.setAttribute("employeeId", selectEmployeeIdParam);
        req.setAttribute("employeeFirstName", selectEmployeeFirstNameParam);
        req.setAttribute("employeeSurname", selectEmployeeSurnameParam);
        req.setAttribute("employeeDateOfBorn", selectEmployeeDateOfBornParam);
        req.setAttribute("employeeAge", selectEmployeeAgeParam);
        req.setAttribute("employeePosition", selectEmployeePositionParam);
        req.getRequestDispatcher("/pages/employee/employees/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
