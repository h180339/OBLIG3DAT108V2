package no.hvl.dat108;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet that shows a list of participants for a party
 * @author Gruppe 19
 * @version 1.0.0
 */
@WebServlet(name = "PaameldingsBekreftelse", urlPatterns = "/paameldingsBekreftelse")
public class PaameldingsBekreftelse extends HttpServlet {



    /**
     * Shows list of participants if user is logged in, if user is not logged in, the user will be redirected to a log in page
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);

        String test = (String) sesjon.getAttribute("fornavn");

        request.setAttribute("fornavn", request.getParameter("fornavn"));
        request.getRequestDispatcher("WEB-INF/PaameldingsBekreftelse.jsp").forward(request, response);
    }
}
