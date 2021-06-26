package my.project.servlet.employee;

import my.project.entity.Employee;
import my.project.service.employee.entity.EmployeeService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet("/all-information-employee")
public class EmployeeAllInformationServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeIdParam = req.getParameter("employeeIdParam");
        Employee employee = new EmployeeService().readEmployeeById(employeeIdParam);
        Blob photo = employee.getPhoto();
        try (InputStream binaryStream = photo.getBinaryStream(1, photo.length())) {
            BufferedImage read = ImageIO.read(binaryStream);
            File imageFile = new File("src/main/webapp/tmp/employeePhoto.jpg");
            ImageIO.write(read, "JPG", imageFile);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("employee", employee);
        req.setAttribute("developer", employee.getDeveloper());
//        req.setAttribute("address", employee.getDeveloper().getAddress());
        req.getRequestDispatcher("/pages/employee/information/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
