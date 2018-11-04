package no.hvl.dat108;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that handles communication with the database
 * @author Gruppe 19
 * @version 1.0.0
 */
@Stateless
public class BrukerEAO {
    @PersistenceContext(name = "DeltakerPU")
    private EntityManager em;

    /**
     * Adds user to database if cell phone number is not in the database
     *
     * @param s
     * @return true/false to indicate if the transaction was successful or not
     */
    public boolean leggTilbruker(Bruker s) {
        Bruker b = hentBruker(s.getMobil());
        if (b == null) {
            em.persist(s);
            return true;
        }else if (!s.getMobil().equals(b.getMobil())) {
            em.persist(s);
            return true;
        }
        return false;
    }

    /**
     *returns user with specified cell phone number
     *
     * @param mobil
     * @return user with specified cell phone number
     */
    public Bruker hentBruker(String mobil) {
        return em.find(Bruker.class, mobil);
    }

    /**
     * returns all the user in the database
     *
     * @return all the user in the database
     */
    public List<Bruker> hentBrukere() {
        return em.createQuery("SELECT s FROM Bruker s").getResultList();
    }
}