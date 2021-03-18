package sn.bachir.domain;

public class Utilisateur {
    private int id;
    private String nomPrenom;
    private String profil;
    private String email;
    private String tel;
    private String dateNaissance;
    private boolean etat;
    private String fonction;

    public Utilisateur(int id, String nomPrenom, String profil, String email, String tel, String dateNaissance, boolean etat, String fonction) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.profil = profil;
        this.email = email;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.etat = etat;
        this.fonction = fonction;
    }

    public int getId() {
        return id;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public String getProfil() {
        return profil;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public boolean isEtat() {
        return etat;
    }

    public String getFonction() {
        return fonction;
    }
}
