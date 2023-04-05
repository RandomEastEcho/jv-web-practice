package mate.controller.drivers;

import mate.lib.Injector;
import mate.model.Driver;
import mate.service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/drivers/create-a-driver")
public class CreateADriverController extends HttpServlet {
    public static final Injector injector = Injector.getInstance("mate");
    public static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/createADriver.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Driver driver = new Driver();
        String name = req.getParameter("name");
        String licenseNumber = req.getParameter("license_number");
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driverService.create(driver);
        resp.sendRedirect(req.getContextPath() + "/drivers");
    }
}