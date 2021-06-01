package my.project.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    public HomeServlet() {
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.sendRedirect("home.html");
        req.getRequestDispatcher("/pages/personListPage.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
