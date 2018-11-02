package no.hvl.dat108;

import org.apache.commons.text.StringEscapeUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema = "dat108oblig3", name = "bruker")
public class Bruker {
    private String fornavn;
    private String etternavn;
    @Id
    private String mobil;
    private String passordHash;
    private String kjonn;

    public Bruker(HttpServletRequest request) {
        this.fornavn = StringEscapeUtils.escapeHtml4(request.getParameter("fornavn"));
        this.etternavn = StringEscapeUtils.escapeHtml4(request.getParameter("etternavn"));
        this.mobil = StringEscapeUtils.escapeHtml4(request.getParameter("mobil"));
        this.kjonn = StringEscapeUtils.escapeHtml4(request.getParameter("kjoenn"));
        this.passordHash = PassordUtil.krypterPassord(StringEscapeUtils.escapeHtml4(request.getParameter("passord")));
        if(request.getParameter("mann") != null) {
            this.kjonn = "mann";
        }else if (request.getParameter("kvinne") != null) {
            this.kjonn = "kvinne";
        }

    }
    public Bruker() {
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getPasswordHash() {
        return passordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passordHash = passwordHash;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
}
