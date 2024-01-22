package fr.tp.tpnoterattrapage.model;

public class Critere {
    private double seuilInferieur;
    private double seuilSuperieur;
    private int r;
    private int g;
    private int b;
    private String nomCritere;

    public boolean verificationCritere(double dValue) {
        boolean retour = false;
        if (dValue<this.getSeuilInferieur() || dValue>this.getSeuilSuperieur()){
            return retour;
        }
        return true;
    }

    public Critere(double seuilInferieur, double seuilSuperieur, int r, int g, int b, String nomCritere) {
        this.seuilInferieur = seuilInferieur;
        this.seuilSuperieur = seuilSuperieur;
        this.r = r;
        this.g = g;
        this.b = b;
        this.nomCritere = nomCritere;
    }

    public double getSeuilInferieur() {
        return seuilInferieur;
    }

    public void setSeuilInferieur(double seuilInferieur) {
        this.seuilInferieur = seuilInferieur;
    }

    public double getSeuilSuperieur() {
        return seuilSuperieur;
    }

    public void setSeuilSuperieur(double seuilSuperieur) {
        this.seuilSuperieur = seuilSuperieur;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getNomCritere() {
        return nomCritere;
    }

    public void setNomCritere(String nomCritere) {
        this.nomCritere = nomCritere;
    }

    @Override
    public String toString() {
        return "Critere{" +
                "seuilInferieur=" + seuilInferieur +
                ", seuilSuperieur=" + seuilSuperieur +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", nomCritere='" + nomCritere + '\'' +
                '}';
    }
}
