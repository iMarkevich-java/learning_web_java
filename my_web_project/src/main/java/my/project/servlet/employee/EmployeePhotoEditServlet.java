package my.project.servlet.employee;

import my.project.entity.Employee;
import my.project.service.entity.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

@WebServlet("/add-photo-employee")
@MultipartConfig(location = "C:/tmp")
public class EmployeePhotoEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String editEmployeeIdParam = req.getParameter("editEmployeeIdParam");
        Employee employee = new EmployeeService().readEmployeeById(editEmployeeIdParam);
        byte[] imageByte = new byte[0];
        try {
            imageByte = employee.getPhoto().getBytes(1, (int) employee.getPhoto().length());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        resp.setContentType("image/jpg");
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(imageByte);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String editEmployeeIdParam = req.getParameter("editEmployeeIdParam");
        Employee employee = new EmployeeService().readEmployeeById(editEmployeeIdParam);
        byte[] imageByte = new byte[0];
        try {
            imageByte = employee.getPhoto().getBytes(1, (int) employee.getPhoto().length());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        resp.setContentType("image/jpg");
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(imageByte);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
