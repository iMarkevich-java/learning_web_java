package my.project.servlet.employee;

import my.project.exceptions.EmployeeWebException;
import my.project.service.entity.EmployeeService;
import my.project.service.entity.StringToSqlDate;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/registration-employee")

public class EmployeeRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/employee/registration/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part image = req.getPart("image");
        byte[] bytes = IOUtils.toByteArray(image.getInputStream());
        Blob imageBlob = null;
        try {
            imageBlob = new SerialBlob(bytes);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String employeeFirstNameParam = req.getParameter("employeeFirstNameParam");
        String employeeSurnameParam = req.getParameter("employeeSurnameParam");
        String employeeDateOfBornParam = req.getParameter("employeeDateOfBornParam");
        String employeeAgeParam = req.getParameter("employeeAgeParam");
        String employeePositionParam = req.getParameter("employeePositionParam");
        try {
            new EmployeeService().createEmployee(imageBlob, employeeFirstNameParam, employeeSurnameParam, new StringToSqlDate().parse(employeeDateOfBornParam), employeePositionParam);
            req.getRequestDispatcher("/employees").forward(req, resp);
        } catch (EmployeeWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.setAttribute("employeeFirstName", employeeFirstNameParam);
            req.setAttribute("employeeSurname", employeeSurnameParam);
            req.setAttribute("employeeDateOfBorn", employeeDateOfBornParam);
            req.setAttribute("employeeAge", employeeAgeParam);
            req.setAttribute("employeePosition", employeePositionParam);
            req.getRequestDispatcher("/pages/employee/registration/index.jsp").forward(req, resp);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
