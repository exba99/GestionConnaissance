package sn.bachir.domain;

public class Prestation {
    private int id;
    private String nom;

    public Prestation(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
