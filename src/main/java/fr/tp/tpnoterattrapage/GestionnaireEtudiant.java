package fr.tp.tpnoterattrapage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GestionnaireEtudiant extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionnaireEtudiant.class.getResource("IHM.fxml"));
        GridPane root = fxmlLoader.load();  // Utilisez VBox ici au lieu de GridPane

        Scene scene = new Scene(root, 600, 200);
        scene.setFill(Color.LIGHTGRAY); // Changer la couleur de fond

        stage.setTitle("Validation");
        stage.setScene(scene);
        stage.setResizable(false); // Rendre la fenêtre non redimensionnable
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icone3il.png")))); // Ajouter l'icône

        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}