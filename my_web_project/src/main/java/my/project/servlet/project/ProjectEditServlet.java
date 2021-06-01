package my.project.servlet.project;

import my.project.exceptions.ProjectWebException;
import my.project.service.entity.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit-project")
public class ProjectEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String editProjectIdParam = req.getParameter("editProjectIdParam");
        String editProjectBudgetParam = req.getParameter("editProjectBudgetParam");
        String editProjectProjectNameParam = req.getParameter("editProjectProjectNameParam");
        String editProjectTimeLimitParam = req.getParameter("editProjectTimeLimitParam");
        String editProjectDeadlineParam = req.getParameter("editProjectDeadlineParam");

        req.setAttribute("projectIdParam", editProjectIdParam);
        req.setAttribute("projectBudgetParam", editProjectBudgetParam);
        req.setAttribute("projectNameParam", editProjectProjectNameParam);
        req.setAttribute("projectTimeLimitParam", editProjectTimeLimitParam);
        req.setAttribute("projectDeadlineParam", editProjectDeadlineParam);
        req.getRequestDispatcher("/pages/project/edit/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateProjectIdParam = req.getParameter("updateProjectIdParam");
        String updateProjectBudgetParam = req.getParameter("updateProjectBudgetParam");
        String updateProjectNameParam = req.getParameter("updateProjectNameParam");
        String updateProjectTimeLimitParam = req.getParameter("updateProjectTimeLimitParam");
        String updateProjectDeadlineParam = req.getParameter("updateProjectDeadlineParam");

        try {
            new ProjectService().updateProjectById(updateProjectIdParam, updateProjectBudgetParam, updateProjectNameParam, updateProjectTimeLimitParam, updateProjectDeadlineParam);
            req.getRequestDispatcher("/projects").forward(req, resp);
        } catch (ProjectWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("message", errorList);
            req.setAttribute("updateProjectIdParam", updateProjectIdParam);
            req.setAttribute("updateProjectBudgetParam", updateProjectBudgetParam);
            req.setAttribute("updateProjectProjectNameParam", updateProjectNameParam);
            req.setAttribute("updateProjectTimeLimitParam", updateProjectTimeLimitParam);
            req.setAttribute("updateProjectDeadlineParam", updateProjectDeadlineParam);
            req.getRequestDispatcher("/pages/project/edit/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
