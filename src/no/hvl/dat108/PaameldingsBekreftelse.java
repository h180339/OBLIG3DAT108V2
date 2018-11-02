package no.hvl.dat108;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PaameldingsBekreftelse", urlPatterns = "/paameldingsBekreftelse")
public class PaameldingsBekreftelse extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);

        String test = (String) sesjon.getAttribute("fornavn");

        request.setAttribute("fornavn", request.getParameter("fornavn"));
        request.getRequestDispatcher("WEB-INF/PaameldingsBekreftelse.jsp").forward(request, response);
    }
}
