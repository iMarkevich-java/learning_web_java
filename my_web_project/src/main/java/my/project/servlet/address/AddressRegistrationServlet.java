package my.project.servlet.address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration-address")
public class AddressRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/address/registration/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String addressCountryParam = req.getParameter("addressCountryParam");
//        String addressRegionParam = req.getParameter("addressRegionParam");
//        String addressLocalityParam = req.getParameter("addressLocalityParam");
//        String addressCityParam = req.getParameter("addressCityParam");
//        String addressStreetParam = req.getParameter("addressStreetParam");
//        String addressHouseParam = req.getParameter("addressHouseParam");
//        String addressFlatParam = req.getParameter("addressFlatParam");
//
//        try {
//            new AddressService().createAddress(addressCountryParam, addressRegionParam, addressLocalityParam,
//                    addressCityParam, addressStreetParam, addressHouseParam, addressFlatParam);
//            req.getRequestDispatcher("/addresses").forward(req, resp);
//        } catch (AddressWebException e) {
//            List<String> errorList = e.getErrorList();
//            req.setAttribute("messageList", errorList);
//            req.setAttribute("addressCountry", addressCountryParam);
//            req.setAttribute("addressRegion", addressRegionParam);
//            req.setAttribute("addressLocality", addressLocalityParam);
//            req.setAttribute("addressCity", addressCityParam);
//            req.setAttribute("addressStreet", addressStreetParam);
//            req.setAttribute("addressHouse", addressHouseParam);
//            req.setAttribute("addressFlat", addressFlatParam);
//            req.getRequestDispatcher("/address/registration/index.jsp").forward(req, resp);
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
