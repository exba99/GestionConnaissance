package com.connaissances.service.console;

import com.connaissances.domain.*;
import com.connaissances.service.DisplayService;

public class ConsoleDisplayService implements DisplayService {

    public void afficherBienvenu() {
        System.out.println("Bienvenu sur la plateforme gestion de connaissance!");
    }

    public void afficherMenuPrincipal() {
        System.out.println("> l pour lister les commentaires disponibles ");
    }

    @Override
    public void afficherListeCommentaire(Commentaire[] commentaires) {
        System.out.println("Les commentaires disponibles sont:");
        for (int i = 0; i < commentaires.length; i++) {
            Commentaire commentaire = commentaires[i];
            System.out.println(String.format(">" +
                    "Id: %s \n" +
                    "sujet: %s \n " +
                    "utilisateur: %s \n" +
                    "description: %s \n" +
                    "date commentaires: %s \n", commentaire.getId(), commentaire.getSujet().getTitre(), commentaire.getUser().getNomPrenom(), commentaire.getDescription(), commentaire.getDateCom()));
        }
    }

    @Override
    public void afficherUnCommentaire(Commentaire commentaire) {
        System.out.println("Les details du commentaire choisi sont:");
        System.out.println(String.format(">" +
                "Id: %s \n" +
                "sujet: %s \n " +
                "utilisateur: %s \n" +
                "description: %s \n" +
                "date commentaires: %s \n", commentaire.getId(), commentaire.getSujet().getTitre(), commentaire.getUser().getNomPrenom(), commentaire.getDescription(), commentaire.getDateCom()));
    }

    @Override
    public void afficherListeSujetByUser(Sujet[] sujets) {
        System.out.println("Les sujets rediges par cette utilisateur sont:");
        for (int i = 0; i < sujets.length; i++) {
            Sujet sujet = sujets[i];
            System.out.println(String.format(">" +
                    "Id: %s \n" +
                    "Titre: %s \n " +
                    "Description: %s \n" +
                    "Date publication: %s \n" +
                    "Moniteur: %s \n" +
                    "Categorie: %s \n", sujet.getId(), sujet.getTitre(), sujet.getDescription(), sujet.getDatePublication(), sujet.getMoniteur().getNomPrenom(), sujet.getCategorie().getLibelle()));
        }
    }

    public void afficherOptionInconnue() {
        System.out.println("Choix inconnu");
    }
}
