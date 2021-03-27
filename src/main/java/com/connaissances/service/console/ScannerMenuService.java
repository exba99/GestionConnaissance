package com.connaissances.service.console;

import com.connaissances.domain.*;
import com.connaissances.repository.*;
import com.connaissances.service.DisplayService;
import com.connaissances.service.MenuService;

import java.util.Scanner;

public class ScannerMenuService implements MenuService {
    private final DisplayService displayService;
    private final Scanner scanner;
    private final CommentaireRepository commentaireRepository;
    private final SujetRepository sujetRepository;
    private final CategorieRepository categorieRepository;

    public ScannerMenuService(DisplayService displayService, CommentaireRepository commentaireRepository, SujetRepository sujetRepository,CategorieRepository categorieRepository) {
        this.displayService = displayService;
        this.commentaireRepository = commentaireRepository;
        this.scanner = new Scanner(System.in);
        this.sujetRepository = sujetRepository;
        this.categorieRepository = categorieRepository;
    }


    private String lireChoix() {
        return scanner.next();
    }

    private void afficherMenu( String choix) {
        Commentaire[] commentaires = commentaireRepository.getAll();
        if("l".equalsIgnoreCase(choix)){
            displayService.afficherListeCommentaire(commentaires);
            System.out.println("Entrer l'id du commentaire a afficher : ");
            int idCommentaire = scanner.nextInt();

            //get commentaire by id
            Commentaire commentaire = commentaireRepository.findById(idCommentaire);
            displayService.afficherUnCommentaire(commentaire);
            //get user in commentaire
            Utilisateur user = commentaire.getUser();
            Sujet[] sujets = sujetRepository.getAllByRedacteur(user);
            //afficher les sujets de cette utilisateur
            displayService.afficherListeSujetByUser(sujets);

            // int idCategorie = scanner.nextInt();
            // Categorie categorie = categorieRepository.findById(idCategorie);
            // Afficher la categorie de ce sujet
        }
        //afficher le menu inconnu
        else {
            displayService.afficherOptionInconnue();
        }
    }

    public void afficherMenu() {
        String choix = lireChoix();
        afficherMenu(choix );
    }
}
