package no.hvl.dat108;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logginn", urlPatterns = "/logginn")
public class Logginn extends HttpServlet {

    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobil = request.getParameter("mobil");
        String passord = request.getParameter("passord");


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
            sesjon.setMaxInactiveInterval(100000);
            sesjon.setAttribute("bruker", testBruker);
            response.sendRedirect("/deltagerliste");
        } else {
            request.setAttribute("feilmelding", "Feil mobil nummer eller passord");

            request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
        //test test
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
                response.sendRedirect("/deltagerliste");
            }
        }

    }
}
