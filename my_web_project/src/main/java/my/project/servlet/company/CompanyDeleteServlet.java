package my.project.servlet.company;

import my.project.service.employee.entity.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-company")
public class CompanyDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteCompanyIdParam = req.getParameter("deleteCompanyIdParam");
        new CompanyService().deleteCompanyById(deleteCompanyIdParam);
        req.getRequestDispatcher("/companies").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
