package fr.tp.tpnoterattrapage.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireEtudiant {

    private List<Etudiant> promotion = new ArrayList<>();
    private List<Critere> references = new ArrayList<>();


    public Critere getCritere(Etudiant etd) {
        for(Critere critere : this.getListeCritere()){
            if(critere.verificationCritere(etd.getMoyenne())){
                return critere;
            }
        }
        return null;
    }

    public GestionnaireEtudiant() throws IOException {
        this.promotion = new ArrayList<>();
        this.promotion.add(new Etudiant("AA","CC",2));
        this.promotion.add(new Etudiant("BB","SS",10));
        this.promotion.add(new Etudiant("BG","Grosse bite",16));
        this.chargerCriteres();
    }


    public void chargerCriteres() throws IOException {
        String cheminFichier = "src/main/resources/fr/tp/tpnoterattrapage/data/criteres.txt";
        Path path = Paths.get(cheminFichier);
        if (!Files.exists(path)) {
            throw new FileNotFoundException("Le fichier de critères n'existe pas: " + cheminFichier);
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(" ");

                try {
                    double seuilInf = Double.parseDouble(parts[0]);
                    double seuilSup = Double.parseDouble(parts[1]);
                    int r = Integer.parseInt(parts[2]);
                    int g = Integer.parseInt(parts[3]);
                    int b = Integer.parseInt(parts[4]);
                    String nomCritere = ligne.substring(ligne.indexOf(parts[5])); // Le reste de la ligne est le nom du critère

                    Critere critere = new Critere(seuilInf, seuilSup, r, g, b, nomCritere);
                    references.add(critere); // Supposons que vous avez une liste de critères nommée 'references'
                } catch (NumberFormatException e) {
                    // Gérer l'erreur de formatage des nombres
                }
            }
        }
    }

    public void sauvegarderPromotion() throws IOException {
        File dossierData = new File("Data");
        if (!dossierData.exists()) {
            dossierData.mkdir();
        }
        File fichierSauvegarde = new File(dossierData, "SaveList.bin");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSauvegarde))) {
            oos.writeObject(promotion);
        }
    }

    public void chargerPromotion() throws IOException, ClassNotFoundException {
        File fichierSauvegarde = new File("Data/SaveList.bin");
        if (!fichierSauvegarde.exists()) {
            throw new FileNotFoundException("Le fichier de sauvegarde n'existe pas: " + fichierSauvegarde);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichierSauvegarde))) {
            promotion = (List<Etudiant>) ois.readObject();
        }
    }


    public List<Critere> getListeCritere(){
        return this.references;
    }

    public  List<Etudiant> getListeEtudiant() {
        return promotion;
    }
}
