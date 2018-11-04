package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

/**
 * A class that checks if the user has the correct inputs
 * @author Gruppe 19
 * @version 1.0.0
 */
public class paamelingsObjekt {
    private String fornavn;
    private String fornavnFeilmelding;
    private String etternavn;
    private String etternavnFeilmelding;
    private String mobil;
    private String tlfNrFeilmelding;
    private String passord;
    private String passordFeilmelding;
    private String repetePassord;
    private String repetePassordFeilmelding;
    private String mann;
    private String kvinne;
    private String kjonnFeilmelding;

    private String checked = "checked";
    private String dameCheck;
    private String manCheck;

    /**
     * Constructs a paamelingsObjekt
     *
     * @param request
     */
    public paamelingsObjekt(HttpServletRequest request) {
        this.fornavn = request.getParameter("fornavn");
        this.etternavn = request.getParameter("etternavn");
        this.mobil = request.getParameter("mobil");
        this.passord = request.getParameter("passord");
        this.repetePassord = request.getParameter("passordRepetert");
        this.mann = request.getParameter("mann");
        this.kvinne = request.getParameter("kvinne");
        this.manCheck = "";
        this.dameCheck = "";
    }

    /**
     * Empty constructor
     */
    public paamelingsObjekt() {

    }


    /**
     * Checks if all inputs are valid by calling all the check validation methods
     * @return boolean
     */
    public boolean isAllInputGyldig() {
        return isFornavnGyldig() && isEtternavnGyldig() && isTlfGyldig() && isPassordGyldig() && isRepeterPassordGyldig() && isKjonnGyldig();
    }

    /**
     * Sets error messages
     */
    public void settOppFeilmeldinger() {
        if (!isFornavnGyldig()) {
            fornavn = "";
            fornavnFeilmelding = "Ugyldig fornvan";
        }
        if (!isEtternavnGyldig()) {
            etternavn = "";
            etternavnFeilmelding = "Ugyldig etternavn";
        }
        if (!isTlfGyldig()) {
            mobil = "";
            tlfNrFeilmelding = "Ugyldig mobil";
        }
        if (!isPassordGyldig()) {
            passord = "";
            passordFeilmelding = "Ugyldig passord";
        }
        if (!isRepeterPassordGyldig()) {


            if(repetePassord.equals("") && passord.equals("")) {
                repetePassordFeilmelding = "Passord feltene kan ikke være tomme";
            } else {
                repetePassordFeilmelding = "Passordene er ikke like";
            }
            repetePassord = "";

        }
        if (!isKjonnGyldig()) {
            kjonnFeilmelding = "velg mann eller kvinne";
        } else {
            if (mann != null) {
                manCheck = checked;
                System.out.println("hey");
            } else {
                dameCheck = checked;
                System.out.println("hey");
            }
        }
    }

    /**
     * Checks if first name is valid
     * @return boolean
     */
    public boolean isFornavnGyldig() {
        return fornavn.matches("^[A-ZØÆÅ][a-zøæåA-ZØÆÅ -]{1,20}");
    }

    /**
     * Checks if last name is valid
     * @return boolean
     */
    public boolean isEtternavnGyldig() {
        return etternavn.matches("^[A-Z-ØÆÅ][a-zøæåA-ZØÆÅ-]{1,20}");
    }

    /**
     * Checks if cell phone number is valid
     * @return boolean
     */
    public boolean isTlfGyldig() {
        return mobil.matches("\\d{8}");
    }

    /**
     * Checks if password is valid
     * @return boolean
     */
    public boolean isPassordGyldig() {

        return passord == null ? false : passord.matches("^.{5,}$");
    }

    /**
     * Checks if repete password is the same as password
     * @return
     */
    public boolean isRepeterPassordGyldig() {

        return repetePassord == null || repetePassord.equals("") ? false : repetePassord.equals(passord);
    }

    /**
     * Sets error message
     * @param tlfNrFeilmelding
     */
    public void setTlfNrFeilmelding(String tlfNrFeilmelding) {
        this.tlfNrFeilmelding = tlfNrFeilmelding;
    }

    /**
     * Checks if one of the checkboxes is checked
     * @return
     */
    public boolean isKjonnGyldig() {
        return kvinne != null || mann != null;
    }

    /**
     * Sets first name
     * @param fornavn
     */
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    /**
     * Sets last name
     * @param etternavn
     */
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    /**
     * Sets cellphone number
     * @param mobil
     */
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    /**
     * Sets password
     * @param passord
     */
    public void setPassord(String passord) {
        this.passord = passord;
    }

    /**
     * returns first name
     * @return first name
     */
    public String getFornavn() {
        return fornavn;
    }

    /**
     * returns error message for first name
     * @return error message for first name
     */
    public String getFornavnFeilmelding() {
        return fornavnFeilmelding;
    }

    /**
     * returns last name
     * @return last name
     */
    public String getEtternavn() {
        return etternavn;
    }

    /**
     * returns error message for last name
     * @return error message for last name
     */
    public String getEtternavnFeilmelding() {
        return etternavnFeilmelding;
    }

    /**
     * returns cellphone number
     * @return cellphone number
     */
    public String getTlfNr() {
        return mobil;
    }

    /**
     * returns error message for cell phone number
     * @return error message for cell phone number
     */
    public String getTlfNrFeilmelding() {
        return tlfNrFeilmelding;
    }

    /**
     * returns password
     * @return password
     */
    public String getPassord() {
        return passord;
    }

    /**
     * returns error message for password
     * @return error message for password
     */
    public String getPassordFeilmelding() {
        return passordFeilmelding;
    }

    /**
     * returns repete password
     * @return repete password
     */
    public String getRepetePassord() {
        return repetePassord;
    }

    /**
     * returns error message for repete password
     * @return error message for repete password
     */
    public String getRepetePassordFeilmelding() {
        return repetePassordFeilmelding;
    }

    /**
     * returns mann
     * @return mann
     */
    public String getMann() {
        return mann;
    }

    /**
     * returns kvinne
     * @return kvinne
     */
    public String getKvinne() {
        return kvinne;
    }

    /**
     * returns error message for the sex of user
     * @return error message for the sex of user
     */
    public String getKjonnFeilmelding() {
        return kjonnFeilmelding;
    }

    /**
     * returns dameCheck
     * @return dameCheck
     */
    public String getDameCheck() {
        return dameCheck;
    }

    /**
     * Sets dameCheck
     * @param dameCheck
     */
    public void setDameCheck(String dameCheck) {
        this.dameCheck = dameCheck;
    }

    /**
     * returns manCheck
     * @return manCheck
     */
    public String getManCheck() {
        return manCheck;
    }

    /**
     * Sets manCheck
     * @param manCheck
     */
    public void setManCheck(String manCheck) {
        this.manCheck = manCheck;
    }
}
