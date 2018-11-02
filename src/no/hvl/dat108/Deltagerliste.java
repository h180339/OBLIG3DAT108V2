package no.hvl.dat108;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Deltagerliste", urlPatterns = "/deltagerliste")
public class Deltagerliste extends HttpServlet {

    @EJB
    private BrukerEAO brukerEAO;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Bruker bruker = (Bruker) session.getAttribute("bruker");

            if (bruker != null) {
                List<DeltagerRowHelper> rows = new ArrayList<>();
                List<Bruker> brukere = brukerEAO.hentBrukere();

                for (Bruker b : brukere) {
                    String cname = bruker.getMobil() == b.getMobil() ? "deltager_signed_in" : "deltager";
                    rows.add(new DeltagerRowHelper(b, cname));
                }

                request.setAttribute("rows", rows);

                request.getRequestDispatcher("WEB-INF/Deltagerliste.jsp").forward(request, response);
                return;
            }
            response.sendRedirect("/logginn");
        }

    }
}
