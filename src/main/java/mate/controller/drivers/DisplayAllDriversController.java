package mate.controller.drivers;

import mate.lib.Injector;
import mate.service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/drivers/display-all-drivers")
public class DisplayAllDriversController extends HttpServlet {
    public static final Injector injector = Injector.getInstance("mate");
    public static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("drivers", driverService.getAll());
        req.getRequestDispatcher("/WEB-INF/views/drivers/displayDrivers.jsp").forward(req, resp);
    }
}