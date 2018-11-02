package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;


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

    public paamelingsObjekt(HttpServletRequest request) {
        this.fornavn = request.getParameter("fornavn");
        this.etternavn = request.getParameter("etternavn");
        this.mobil = request.getParameter("mobil");
        this.passord = request.getParameter("passord");
        this.repetePassord = request.getParameter("passordRepetert");
        this.mann = request.getParameter("mann");
        this.kvinne = request.getParameter("kvinne");
    }


    public boolean isAllInputGyldig() {
        return isFornavnGyldig() && isEtternavnGyldig() && isTlfGyldig() && isPassordGyldig() && isRepeterPassordGyldig() && isKjonnGyldig();
    }

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
            repetePassord = "";
            repetePassordFeilmelding = "Passordene må være like";
        }
        if (!isKjonnGyldig()) {
            kjonnFeilmelding = "Du må oppgi mann";
        }
    }

    public boolean isFornavnGyldig() {
        return fornavn.matches("^[A-ZØÆÅ][a-zøæåA-ZØÆÅ -]{1,20}");
    }

    public boolean isEtternavnGyldig() {
        return etternavn.matches("^[A-ZØÆÅ][a-zøæåA-ZØÆÅ-]{1,20}");
    }

    public boolean isTlfGyldig() {
        return mobil.matches("\\d{8}");
    }

    public boolean isPassordGyldig() {

        return passord == null ? false : passord.matches("^.{5,}$");
    }

    public boolean isRepeterPassordGyldig() {

        return repetePassord == null || repetePassord.equals("") ? false : repetePassord.equals(passord);
    }

    public boolean isKjonnGyldig() {
        return kvinne != null || mann != null;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getFornavnFeilmelding() {
        return fornavnFeilmelding;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getEtternavnFeilmelding() {
        return etternavnFeilmelding;
    }

    public String getTlfNr() {
        return mobil;
    }

    public String getTlfNrFeilmelding() {
        return tlfNrFeilmelding;
    }

    public String getPassord() {
        return passord;
    }

    public String getPassordFeilmelding() {
        return passordFeilmelding;
    }

    public String getRepetePassord() {
        return repetePassord;
    }

    public String getRepetePassordFeilmelding() {
        return repetePassordFeilmelding;
    }

    public String getMann() {
        return mann;
    }

    public String getKvinne() {
        return kvinne;
    }

    public String getKjonnFeilmelding() {
        return kjonnFeilmelding;
    }


}
