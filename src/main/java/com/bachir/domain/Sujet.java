package sn.bachir.domain;

public class Sujet {
    private int id;
    private String titre;
    private String description;
    private String datePublication;
    private String statut;
    private Categorie categorie;
    private Utilisateur moniteur;
    private Utilisateur redacteur;

    public Sujet(int id, String titre, String description, String datePublication, String statut, Categorie categorie, Utilisateur moniteur, Utilisateur redacteur) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.statut = statut;
        this.categorie = categorie;
        this.moniteur = moniteur;
        this.redacteur = redacteur;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public String getStatut() {
        return statut;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Utilisateur getMoniteur() {
        return moniteur;
    }

    public Utilisateur getRedacteur() {
        return redacteur;
    }
}
