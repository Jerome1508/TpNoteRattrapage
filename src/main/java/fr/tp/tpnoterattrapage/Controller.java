package fr.tp.tpnoterattrapage;

import fr.tp.tpnoterattrapage.model.Critere;
import fr.tp.tpnoterattrapage.model.Etudiant;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField nomTextField;
    @FXML
    private TextField prenomTextField;
    @FXML
    private TextField moyenneTextField;
    @FXML
    private ListView<Label> etudiantListView;

    private ObservableList<Label> listeEtudiantLabels;
    private fr.tp.tpnoterattrapage.model.GestionnaireEtudiant gestionnaireEtudiant;

    @FXML
    public void initialize() {
        try {
            gestionnaireEtudiant = new fr.tp.tpnoterattrapage.model.GestionnaireEtudiant();

            gestionnaireEtudiant.chargerPromotion();

            // Initialisation de la liste observable de Labels
            listeEtudiantLabels = etudiantListView.getItems();

            for (Etudiant etd : gestionnaireEtudiant.getListeEtudiant()) {
                Critere critere = gestionnaireEtudiant.getCritere(etd);
                Label etudiantLabel = new Label(etd.toString());
                if (critere != null) {
                    etudiantLabel.setTextFill(Color.rgb(critere.getR(), critere.getG(), critere.getB()));
                }
                listeEtudiantLabels.add(etudiantLabel);
            }
        } catch (IOException e) {


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void actionEnregistrer(ActionEvent evt) {
        try {
            double moyenne = Double.parseDouble(moyenneTextField.getText());
            Etudiant nouvelEtudiant = new Etudiant(nomTextField.getText(), prenomTextField.getText(), moyenne);
            gestionnaireEtudiant.getListeEtudiant().add(nouvelEtudiant);



            Critere critere = gestionnaireEtudiant.getCritere(nouvelEtudiant);
            Label etudiantLabel = new Label(nouvelEtudiant.toString());
            if (critere != null) {
                etudiantLabel.setTextFill(Color.rgb(critere.getR(), critere.getG(), critere.getB()));
            }
            listeEtudiantLabels.add(etudiantLabel);

            // Nettoyage des champs de saisie
            nomTextField.clear();
            prenomTextField.clear();
            moyenneTextField.clear();
            gestionnaireEtudiant.sauvegarderPromotion();
        } catch (NumberFormatException e) {
            // Gérer l'exception si la moyenne n'est pas un nombre
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'exception d'IO (afficher un message d'erreur à l'utilisateur, etc.)
        }


    }


}