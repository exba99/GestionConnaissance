package sn.bachir.domain;

public class Commentaire {
    private int id;
    private String dateCom;
    private String description;
    private boolean etat;
    private Sujet sujet;
    private Utilisateur user;

    public Commentaire(int id, String dateCom, String description, boolean etat, Sujet sujet, Utilisateur user) {
        this.id = id;
        this.dateCom = dateCom;
        this.description = description;
        this.etat = etat;
        this.sujet = sujet;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getDateCom() {
        return dateCom;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEtat() {
        return etat;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public Utilisateur getUser() {
        return user;
    }
}
