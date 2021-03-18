package sn.bachir.domain;

public class Prestataire {
    private int id;
    private String prenom;
    private String nom;
    private Prestation prestation;

    public Prestataire(int id, String prenom, String nom, Prestation prestation) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.prestation = prestation;
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
}
