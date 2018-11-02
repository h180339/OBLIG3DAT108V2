package no.hvl.dat108;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Ferdig", urlPatterns = "/loggut")
public class Ferdig extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("bruker") == null)  {
            response.sendRedirect("/logginn");
            return;
        }else if (session != null) {
            request.getRequestDispatcher("WEB-INF/Ferdig.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("/logginn");
    }
}
