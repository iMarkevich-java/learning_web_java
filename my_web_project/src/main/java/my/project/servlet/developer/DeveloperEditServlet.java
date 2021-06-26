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

@WebServlet("/edit-developer")
public class DeveloperEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String editDeveloperIdParam = req.getParameter("editDeveloperIdParam");
        String editDeveloperDepartmentParam = req.getParameter("editDeveloperDepartmentParam");
        String editDeveloperExperienceParam = req.getParameter("editDeveloperExperienceParam");

        req.setAttribute("developerIdParam", editDeveloperIdParam);
        req.setAttribute("developerDepartmentParam", editDeveloperDepartmentParam);
        req.setAttribute("editDeveloperExperienceParam", editDeveloperExperienceParam);

        req.getRequestDispatcher("/pages/developer/edit/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateDeveloperIdParam = req.getParameter("updateDeveloperIdParam");
        String updateDeveloperDepartmentParam = req.getParameter("updateDeveloperDepartmentParam");
        String updateDeveloperExperienceParam = req.getParameter("updateDeveloperExperienceParam");

        try {
            new DeveloperService().updateDeveloperById(updateDeveloperIdParam, updateDeveloperDepartmentParam, Integer.parseInt(updateDeveloperExperienceParam));
            req.getRequestDispatcher("/developers").forward(req, resp);
        } catch (DeveloperWebException e) {
            e.printStackTrace();
            List<String> errorList = e.getErrorList();
            req.setAttribute("message", errorList);
            req.setAttribute("updateDeveloperIdParam", updateDeveloperIdParam);
            req.setAttribute("updateDeveloperDepartmentParam", updateDeveloperDepartmentParam);
            req.setAttribute("updateDeveloperExperienceParam", updateDeveloperExperienceParam);
            req.getRequestDispatcher("/pages/developer/edit/index.jsp").forward(req, resp);

        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
