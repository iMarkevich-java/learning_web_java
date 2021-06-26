package my.project.servlet.employee;

import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import my.project.service.employee.entity.EmployeeService;
import my.project.service.employee.entity.StringToSqlDate;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/edit-employee")
@MultipartConfig(location = "C:/tmp")
public class EmployeeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String editEmployeeIdParam = req.getParameter("editEmployeeIdParam");
        Employee employee = new EmployeeService().readEmployeeById(editEmployeeIdParam);
        Blob photo = employee.getPhoto();
        try (InputStream binaryStream = photo.getBinaryStream(1, photo.length())) {
            BufferedImage read = ImageIO.read(binaryStream);
            File imageFile = new File("src/main/webapp/tmp/employeePhoto.jpg");
            ImageIO.write(read, "JPG", imageFile);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/pages/employee/edit/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateEditEmployeeIdParam = req.getParameter("updateEmployeeIdParam");
        String updateEmployeeFirstNameParam = req.getParameter("updateEmployeeFirstNameParam");
        String updateEmployeeSurnameParam = req.getParameter("updateEmployeeSurnameParam");
        String updateEmployeeDateOfBornParam = req.getParameter("updateEmployeeDateOfBornParam");
        String updateEmployeePositionParam = req.getParameter("updateEmployeePositionParam");

        Blob imageBlob = null;
        Part image = req.getPart("image");

        if (image.getSize() == 0) {
            Employee employee = new EmployeeService().readEmployeeById(updateEditEmployeeIdParam);
            imageBlob = employee.getPhoto();
        } else {
            byte[] bytes = IOUtils.toByteArray(image.getInputStream());
            try {
                imageBlob = new SerialBlob(bytes);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        try {
            new EmployeeService().updateEmployeeById(updateEditEmployeeIdParam, imageBlob, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, new StringToSqlDate().parse(updateEmployeeDateOfBornParam), updateEmployeePositionParam);
            req.getRequestDispatcher("/employees").forward(req, resp);
        } catch (EmployeeWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.setAttribute("employeeIdParam", updateEditEmployeeIdParam);
            req.setAttribute("employeeFirstNameParam", updateEmployeeFirstNameParam);
            req.setAttribute("employeeSurnameParam", updateEmployeeSurnameParam);
            req.setAttribute("employeeDateOfBornParam", updateEmployeeDateOfBornParam);
            req.setAttribute("employeePositionParam", updateEmployeePositionParam);
            req.getRequestDispatcher("/pages/employee/edit/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
