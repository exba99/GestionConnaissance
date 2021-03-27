package com.connaissances.controller;

import com.connaissances.repository.*;
import com.connaissances.repository.jdbc.*;
import com.connaissances.service.DisplayService;
import com.connaissances.service.MenuService;
import com.connaissances.service.console.ConsoleDisplayService;
import com.connaissances.service.console.ScannerMenuService;


/**
 * End point destiné aux clients
 * Deux fonctionnalités (services)
 * 1 - Afficher le menu au client : ConsoleDisplayService
 * 2 - Lire les choix du client et afficher le sous-menu correspondant : ScannerMenuService
 */
public class ClientController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;

    public ClientController(){
        DataSource dataSource = new MysqlDataSource();
        displayService = new ConsoleDisplayService();
        CommentaireRepository commentaireRepository = new JdbcBasedCommentaireRepository(dataSource);
        SujetRepository sujetRepository = new JdbcBasedSujetRepository(dataSource);
        CategorieRepository categorieRepository = new JdbcBasedCategorieRepository(dataSource);
        scannerMenuService = new ScannerMenuService(displayService, commentaireRepository, sujetRepository, categorieRepository );
    }

    public void process(){
        displayService.afficherBienvenu();
        displayService.afficherMenuPrincipal();
        scannerMenuService.afficherMenu();
    }


}
