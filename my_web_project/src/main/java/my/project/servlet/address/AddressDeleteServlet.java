package my.project.servlet.address;

import my.project.service.entity.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-address")
public class AddressDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new AddressService().deleteAddressById(req.getParameter("deleteAddressIdParam"));
        req.getRequestDispatcher("/addresses").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
