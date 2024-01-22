package fr.tp.tpnoterattrapage.test;

import fr.tp.tpnoterattrapage.model.Critere;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CritereTest {

    @Test
    public void testVerificationCritere() {
        Critere critere = new Critere(0, 10, 255, 0, 0, "Critère 1");
        assertTrue(critere.verificationCritere(5));
        assertFalse(critere.verificationCritere(15));
    }

    // Plus de tests peuvent être ajoutés ici
}