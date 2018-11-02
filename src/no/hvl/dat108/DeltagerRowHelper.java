package no.hvl.dat108;

public class DeltagerRowHelper {
    private Bruker bruker;
    private String classname;

    public DeltagerRowHelper() {

    }

    public DeltagerRowHelper(Bruker bruker, String classname) {
        this.bruker = bruker;
        this.classname = classname;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}