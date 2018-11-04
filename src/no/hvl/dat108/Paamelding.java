package no.hvl.dat108;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "Paamelding", urlPatterns = "/paamelding")
public class Paamelding extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int loginTime;

    @EJB
    private BrukerEAO brukerEAO;

    @Override
    public void init() throws ServletException {
        loginTime = Integer.parseInt(getServletConfig().getInitParameter("LoginTime"));
    }

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/Paamelding.jsp").forward(request, response);
    }
}
