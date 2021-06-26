package my.project.servlet.address;

import my.project.exceptions.AddressWebException;
import my.project.service.employee.entity.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit-address")
public class AddressEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("editAddressIdParam", req.getParameter("editAddressIdParam"));
        req.setAttribute("editAddressCountryParam", req.getParameter("editAddressCountryParam"));
        req.setAttribute("editAddressRegionParam", req.getParameter("editAddressRegionParam"));
        req.setAttribute("editAddressLocalityParam", req.getParameter("editAddressLocalityParam"));
        req.setAttribute("editAddressCityParam", req.getParameter("editAddressCityParam"));
        req.setAttribute("editAddressStreetParam", req.getParameter("editAddressStreetParam"));
        req.setAttribute("editAddressHouseParam", req.getParameter("editAddressHouseParam"));
        req.setAttribute("editAddressFlatParam", req.getParameter("editAddressFlatParam"));

        req.getRequestDispatcher("/pages/address/edit/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String updateAddressIdParam = req.getParameter("updateAddressIdParam");
        String updateAddressCountryParam = req.getParameter("updateAddressCountryParam");
        String updateAddressRegionParam = req.getParameter("updateAddressRegionParam");
        String updateAddressLocalityParam = req.getParameter("updateAddressLocalityParam");
        String updateAddressCityParam = req.getParameter("updateAddressCityParam");
        String updateAddressStreetParam = req.getParameter("updateAddressStreetParam");
        String updateAddressHouseParam = req.getParameter("updateAddressHouseParam");
        String updateAddressFlatParam = req.getParameter("updateAddressFlatParam");


        try {
            int house = Integer.parseInt(updateAddressHouseParam);
            int flat = Integer.parseInt(updateAddressFlatParam);
            new AddressService().updateAddressById(updateAddressIdParam, updateAddressCountryParam, updateAddressRegionParam, updateAddressLocalityParam,
                    updateAddressCityParam, updateAddressStreetParam, house, flat);
            req.getRequestDispatcher("/addresses").forward(req, resp);
        } catch (AddressWebException e) {
            List<String> errorList = e.getErrorList();
            req.setAttribute("messageList", errorList);
            req.setAttribute("updateAddressIdParam", updateAddressIdParam);
            req.setAttribute("updateAddressCountryParam", updateAddressCountryParam);
            req.setAttribute("updateAddressRegionParam", updateAddressRegionParam);
            req.setAttribute("updateAddressLocalityParam", updateAddressLocalityParam);
            req.setAttribute("updateAddressCityParam", updateAddressCityParam);
            req.setAttribute("updateAddressStreetParam", updateAddressStreetParam);
            req.setAttribute("updateAddressHouseParam", updateAddressHouseParam);
            req.setAttribute("updateAddressFlatParam", updateAddressFlatParam);
            req.getRequestDispatcher("/pages/address/edit/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
