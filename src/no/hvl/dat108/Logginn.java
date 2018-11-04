package no.hvl.dat108;

import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet that shows a log in page
 * @author Gruppe 19
 * @version 1.0.0
 */
@WebServlet(name = "Logginn", urlPatterns = "/logginn")
public class Logginn extends HttpServlet {
    int loginTime;

    @EJB
    private BrukerEAO brukerEAO;

    /**
     * Gets the init parameter and assigns it to loginTime
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        loginTime = Integer.parseInt(getServletConfig().getInitParameter("LoginTime"));
    }

    /**
     * Logs user in if cell number and password is correct
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobil = StringEscapeUtils.escapeHtml4(request.getParameter("mobil"));
        String passord = StringEscapeUtils.escapeHtml4(request.getParameter("passord"));

        //tester om mobil eller passord er tom
        if(mobil.equals("") || passord.equals("")) {
            request.setAttribute("feilmelding", "Fyll ut alle felt");
            request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
        }

        Bruker testBruker = brukerEAO.hentBruker(mobil);
        if (testBruker != null && PassordUtil.sjekkPassord(passord, testBruker.getPasswordHash())) {

            HttpSession sesjon = request.getSession(false);
            if(sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(loginTime);
            sesjon.setAttribute("bruker", testBruker);
            response.sendRedirect("./deltagerliste");
        } else {
            request.setAttribute("feilmelding", "Feil mobil nummer eller passord");
            request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
        }
    }

    /**
     * Shows log in page or deltagerliste, depending on if the users is already logged in
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null) {
            request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);

        } else {
            Bruker loginBruker = (Bruker) session.getAttribute("user");

            if(loginBruker == null) {
                request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
            } else {
                //Redirect til deltagerlisten
                session.setAttribute("user", loginBruker);
                response.sendRedirect("./deltagerliste");
            }
        }

    }
}
