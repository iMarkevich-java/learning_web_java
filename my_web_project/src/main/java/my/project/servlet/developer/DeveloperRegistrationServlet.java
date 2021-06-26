package my.project.servlet.developer;

import my.project.exceptions.DeveloperWebException;
import my.project.service.employee.entity.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration-developer")
public class DeveloperRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/developer/registration/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String developerDepartmentParam = req.getParameter("developerDepartmentParam");
        String developerExperienceParam = req.getParameter("developerExperienceParam");

        try {
            new DeveloperService().createDeveloper(developerDepartmentParam, Integer.parseInt(developerExperienceParam));
            req.getRequestDispatcher("/developers").forward(req, resp);
        } catch (DeveloperWebException e) {
            e.printStackTrace();
            List<String> errorList = e.getErrorList();
            req.setAttribute("messages", errorList);
            req.setAttribute("developerDepartmentParam", developerDepartmentParam);
            req.setAttribute("developerExperienceParam", developerExperienceParam);
            req.getRequestDispatcher("/pages/developer/registration/index.jsp").forward(req, resp);
        }


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
