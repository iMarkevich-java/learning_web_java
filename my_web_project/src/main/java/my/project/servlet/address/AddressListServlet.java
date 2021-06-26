package my.project.servlet.address;

import my.project.entity.Address;
import my.project.service.employee.entity.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addresses")
public class AddressListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Address> addresses = new AddressService().readAllAddress();
        req.setAttribute("addressesList", addresses);
        req.getRequestDispatcher("/pages/address/addresses/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
