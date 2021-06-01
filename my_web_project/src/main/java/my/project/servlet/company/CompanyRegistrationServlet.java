package my.project.servlet.company;

import my.project.exceptions.CompanyWebException;
import my.project.service.entity.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration-company")
public class CompanyRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/company/registration/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyNameParam = req.getParameter("companyNameParam");
        String companyActivityParam = req.getParameter("companyActivityParam");

        try {
            new CompanyService().createCompany(companyNameParam, companyActivityParam);
            req.getRequestDispatcher("/companies").forward(req, resp);
        } catch (CompanyWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.setAttribute("companyName", companyNameParam);
            req.setAttribute("companyActivity", companyActivityParam);
            req.getRequestDispatcher("/pages/company/registration/index.jsp").forward(req, resp);
        }
    }
}
