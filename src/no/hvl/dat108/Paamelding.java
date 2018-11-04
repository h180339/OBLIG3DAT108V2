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
 * A servlet that shows a page where a user can sign up for a party
 * @author Gruppe 19
 * @version 1.0.0
 */
@WebServlet(name = "Paamelding", urlPatterns = "/paamelding")
public class Paamelding extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
     * Checks if inputs are correct, creates a user object and sends it to database, then redirects user to a page with list of users/participants
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        paamelingsObjekt skjema = new paamelingsObjekt(request);

        if(skjema.isAllInputGyldig()){
            Bruker bruker = new Bruker(request);
            boolean lagtTil = brukerEAO.leggTilbruker(bruker);
            //sjekker at mobil nummeret ikke er registrert
            if(!lagtTil) {
                skjema.setTlfNrFeilmelding("Telefon nummer er allerede registrert");
                skjema.setMobil("");
                request.getSession().setAttribute("skjema", skjema);
                response.sendRedirect("/paamelding");
                return;
            }
            HttpSession sesjon = request.getSession(false);
            if(sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(loginTime);

            //setter attributter til sesjonen slik at det kan hentes og vises i paameldingsbekreftelse servleten
            sesjon.setAttribute("bruker", bruker);
            sesjon.setAttribute("fornavn", bruker.getFornavn());
            sesjon.setAttribute("etternavn", bruker.getEtternavn());
            sesjon.setAttribute("mobil", bruker.getMobil());
            sesjon.setAttribute("kjonn", bruker.getKjonn());
            response.sendRedirect("/paameldingsBekreftelse");
        }else{
            skjema.settOppFeilmeldinger();
            request.getSession().setAttribute("skjema", skjema);
            response.sendRedirect("/paamelding");
        }


    }

    /**
     * Shows page where user can register for party
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/Paamelding.jsp").forward(request, response);
    }
}
