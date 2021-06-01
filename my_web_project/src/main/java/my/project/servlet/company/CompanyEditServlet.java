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

@WebServlet("/edit-company")
public class CompanyEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("editCompanyIdParam", req.getParameter("editCompanyIdParam"));
        req.setAttribute("editCompanyNameParam", req.getParameter("editCompanyNameParam"));
        req.setAttribute("editCompanyActivityParam", req.getParameter("editCompanyActivityParam"));
        req.getRequestDispatcher("/pages/company/edit/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateCompanyIdParam = req.getParameter("updateCompanyIdParam");
        String updateCompanyNameParam = req.getParameter("updateCompanyNameParam");
        String updateCompanyActivityParam = req.getParameter("updateCompanyActivityParam");


        try {
            new CompanyService().updateCompanyById(updateCompanyIdParam, updateCompanyNameParam, updateCompanyActivityParam);
            req.getRequestDispatcher("/companies").forward(req, resp);
        } catch (CompanyWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.setAttribute("editCompanyIdParam", updateCompanyIdParam);
            req.setAttribute("editCompanyNameParam", updateCompanyNameParam);
            req.setAttribute("editCompanyActivityParam", updateCompanyActivityParam);
            req.getRequestDispatcher("/pages/company/edit/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
