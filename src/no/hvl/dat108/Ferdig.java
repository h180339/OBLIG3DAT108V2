package no.hvl.dat108;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A serlvet that shows a log out page
 * @author Gruppe 19
 * @version 1.0.0
 */
@WebServlet(name = "Ferdig", urlPatterns = "/loggut")
public class Ferdig extends HttpServlet {


    /**
     * Shows the log out page if you just logged out, if not it will redirect you to a log in page
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session.getAttribute("bruker") == null)  {
            response.sendRedirect("./logginn");
            return;
        }else if (session != null) {
            session.invalidate();
            request.getRequestDispatcher("WEB-INF/Ferdig.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("./logginn");
    }
}
