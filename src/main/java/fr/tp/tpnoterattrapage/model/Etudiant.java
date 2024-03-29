package fr.tp.tpnoterattrapage.model;

import java.io.Serializable;
public class Etudiant implements Serializable {
        private String nom;
        private String prenom;
        private double moyenne;

    public Etudiant(String nom, String prenom, double moyenne) {
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public String toString() {
        return
                nom +" "
               + prenom +" "+
                moyenne;
    }
}
