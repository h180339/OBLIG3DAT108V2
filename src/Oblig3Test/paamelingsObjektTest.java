package Oblig3Test;

import no.hvl.dat108.paamelingsObjekt;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class paamelingsObjektTest {

    paamelingsObjekt objekt = new paamelingsObjekt();
    @Test
    public void isFornavnGyldig() {
        objekt.setFornavn("Per");
        assertTrue(objekt.isFornavnGyldig());

    }

    @Test
    public void isEtternavnGyldig() {
        objekt.setEtternavn("Lik");
        assertTrue(objekt.isEtternavnGyldig());
    }

    @Test
    public void isTlfGyldig() {
        objekt.setMobil("12321221");
        assertTrue(objekt.isTlfGyldig());
    }

    @Test
    public void isPassordGyldig() {
        objekt.setPassord("11111");
        assertTrue(objekt.isPassordGyldig());
    }
}
