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

    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        paamelingsObjekt skjema = new paamelingsObjekt(request);

        if(skjema.isAllInputGyldig()){
            Bruker bruker = new Bruker(request);

            brukerEAO.leggTilbruker(bruker);
            HttpSession sesjon = request.getSession(false);
            if(sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(100000);

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
