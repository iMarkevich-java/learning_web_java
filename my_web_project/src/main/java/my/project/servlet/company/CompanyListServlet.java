package my.project.servlet.company;

import my.project.entity.Company;
import my.project.service.employee.entity.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/companies")
public class CompanyListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companyList = new CompanyService().readAllCompany();
        req.setAttribute("companiesList", companyList);
        req.getRequestDispatcher("/pages/company/companies/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
