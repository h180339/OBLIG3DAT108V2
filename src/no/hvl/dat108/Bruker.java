package no.hvl.dat108;

import org.apache.commons.text.StringEscapeUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

/**
 * A class that holds information about a user
 * @author Gruppe 19
 * @version 1.0.0
 */
@Entity
@Table(schema = "dat108oblig3", name = "bruker")
public class Bruker {
    private String fornavn;
    private String etternavn;
    @Id
    private String mobil;
    private String passordHash;
    private String kjonn;


    /**
     * Constructs a new user
     * @param request , request from servlet
     */
    public Bruker(HttpServletRequest request) {
        this.fornavn = StringEscapeUtils.escapeHtml4(request.getParameter("fornavn"));
        this.etternavn =StringEscapeUtils.escapeHtml4(request.getParameter("etternavn"));
        this.mobil = StringEscapeUtils.escapeHtml4(request.getParameter("mobil"));
        this.passordHash = StringEscapeUtils.escapeHtml4(PassordUtil.krypterPassord(request.getParameter("passord")));
        if (StringEscapeUtils.escapeHtml4(request.getParameter("mann")) != null) {
            String foo = request.getParameter("mann");
            this.kjonn = "mann";
        } else if (StringEscapeUtils.escapeHtml4(request.getParameter("kvinne")) != null) {
            String bar = request.getParameter("kvinne");
            this.kjonn = "kvinne";
        }
    }

    /**
     * Empty constructor
     */
    public Bruker() {
    }

    /**
     * @returns first name of user
     *
     * @return first name of user
     */
    public String getFornavn() {
        return fornavn;
    }

    /**
     * Sets first name of user
     *
     * @param fornavn
     */
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    /**
     * returns last name of user
     *
     * @return last name of user
     */
    public String getEtternavn() {
        return etternavn;
    }

    /**
     * Sets last name of user
     *
     * @param etternavn
     */
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    /**
     * returns cell phone number
     *
     * @return cell phone number
     */
    public String getMobil() {
        return mobil;
    }

    /**
     * Sets cell phone number
     *
     * @param mobil
     */
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    /**
     * returns password hashed
     *
     * @return password hashed
     */
    public String getPasswordHash() {
        return passordHash;
    }


    /**
     * returns the sex of the user
     *
     * @return the sex of the user
     */
    public String getKjonn() {
        return kjonn;
    }

    /**
     * Sets the sex of the user
     *
     * @param kjonn
     */
    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
}
