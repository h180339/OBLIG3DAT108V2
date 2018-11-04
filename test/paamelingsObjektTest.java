import no.hvl.dat108.paamelingsObjekt;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class paamelingsObjektTest {

    paamelingsObjekt objekt = new paamelingsObjekt();

    @Test
    public void isFornavnGyldig() {
        objekt.setFornavn("Per");
        assertTrue(objekt.isFornavnGyldig());
        objekt.setFornavn("per");
        assertFalse(objekt.isFornavnGyldig());

    }

    @Test
    public void isEtternavnGyldig() {
        objekt.setEtternavn("Lik");
        assertTrue(objekt.isEtternavnGyldig());
        objekt.setEtternavn("lik");
        assertFalse(objekt.isEtternavnGyldig());
    }

    @Test
    public void isTlfGyldig() {
        objekt.setMobil("12321221");
        assertTrue(objekt.isTlfGyldig());
        objekt.setMobil("1221221");
        assertFalse(objekt.isTlfGyldig());
    }

    @Test
    public void isPassordGyldig() {
        objekt.setPassord("11111");
        assertTrue(objekt.isPassordGyldig());
        objekt.setPassord("1111");
        assertFalse(objekt.isPassordGyldig());
    }
}
