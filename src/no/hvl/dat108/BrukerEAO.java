package no.hvl.dat108;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BrukerEAO {
    @PersistenceContext(name = "DeltakerPU")
    private EntityManager em;

    public void leggTilbruker(Bruker s) {
        em.persist(s);
    }

    public Bruker hentBruker(String mobil) {
        return em.find(Bruker.class, mobil);
    }

    public List<Bruker> hentBrukere() {
        //TypedQuery<Bruker> query = em.createQuery("SELECT c FROM bruker c", Bruker.class);
        //String queryString = "select e from Bruker e";
        //TypedQuery<Bruker> query = em.createQuery(queryString, Bruker.class);
        //List<Bruker> results = query.getResultList();
        //List al = em.createQuery("SELECT fornavn FROM dat108oblig3.bruker").getResultList();
        //return results;

        return em.createQuery("SELECT s FROM Bruker s").getResultList();
    }
}