package my.project.servlet.project;

import my.project.entity.Project;
import my.project.service.employee.entity.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/projects")
public class ProjectListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Project> projectList = new ProjectService().readAllProject();
        req.setAttribute("projectsList", projectList);
        req.getRequestDispatcher("/pages/project/projects/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
