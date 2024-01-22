package fr.tp.tpnoterattrapage.test;

import fr.tp.tpnoterattrapage.model.Critere;
import fr.tp.tpnoterattrapage.model.Etudiant;
import fr.tp.tpnoterattrapage.model.GestionnaireEtudiant;
import org.junit.Test;

import java.io.IOException;

public class TestGestionnaireEtudiant {

    @Test
    public void testCreationGestionnaire() throws IOException {
        GestionnaireEtudiant gestionnaireEtudiant =new GestionnaireEtudiant();
    }

    @Test
    public void testGetCritereEtudiant() throws IOException {
        GestionnaireEtudiant gestionnaireEtudiant =new GestionnaireEtudiant();
        Etudiant etudiant = new Etudiant("Nom", "Prénom", 4);
        Critere critere  = gestionnaireEtudiant.getCritere(etudiant);
        System.out.println(critere);

    }
}
