package no.hvl.dat108;


/**
 * A class that represents rows in the user list
 */
public class DeltagerRowHelper {
    private Bruker bruker;
    private String classname;

    /**
     * Empty constructor
     */
    public DeltagerRowHelper() {

    }

    /**
     * Constructs a new row
     *
     * @param bruker
     * @param classname
     */
    public DeltagerRowHelper(Bruker bruker, String classname) {
        this.bruker = bruker;
        this.classname = classname;
    }

    /**
     * returns user
     *
     * @return user
     */
    public Bruker getBruker() {
        return bruker;
    }

    /**
     * Sets user
     *
     * @param bruker
     */
    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    /**
     * returns class name
     *
     * @return class name
     */
    public String getClassname() {return classname;}

    /**
     * Sets class name
     *
     * @param classname
     */
    public void setClassname(String classname) {this.classname = classname;}
}