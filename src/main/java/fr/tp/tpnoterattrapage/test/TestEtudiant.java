package fr.tp.tpnoterattrapage.test;


import fr.tp.tpnoterattrapage.model.Etudiant;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestEtudiant {

        @Test
        public void testCreationEtudiant() {
            Etudiant etudiant = new Etudiant("Nom", "Prénom", 12.5);
            assertNotNull(etudiant);
            assertEquals("Nom", etudiant.getNom());
            assertEquals("Prénom", etudiant.getPrenom());
            assertEquals(12.5d, etudiant.getMoyenne(),0);
        }

}
