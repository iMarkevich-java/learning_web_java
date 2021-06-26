package my.project.servlet.project;

import my.project.exceptions.ProjectWebException;
import my.project.service.employee.entity.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration-project")
public class ProjectRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/project/registration/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectNameParam = req.getParameter("projectNameParam");
        String projectBudgetParam = req.getParameter("projectBudgetParam");
        String projectTimeLimitParam = req.getParameter("projectTimeLimitParam");
        String projectDeadlineParam = req.getParameter("projectDeadlineParam");

        try {
            new ProjectService().createProject(projectNameParam, projectBudgetParam, projectTimeLimitParam, projectDeadlineParam);
            req.getRequestDispatcher("/projects").forward(req, resp);
        } catch (ProjectWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("message", errorList);
            req.setAttribute("projectNameParam", projectNameParam);
            req.setAttribute("projectBudgetParam", projectBudgetParam);
            req.setAttribute("projectTimeLimitParam", projectTimeLimitParam);
            req.setAttribute("projectDeadlineParam", projectDeadlineParam);
            req.getRequestDispatcher("/pages/project/registration/index.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
