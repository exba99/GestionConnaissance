package sn.bachir.controller;

import sn.bachir.repository.DetailPrestationRepository;
import sn.bachir.repository.PrestataireRepository;
import sn.bachir.repository.PrestationRepository;
import sn.bachir.repository.jdbc.DataSource;
import sn.bachir.repository.jdbc.JdbcBasedPrestationRepository;
import sn.bachir.repository.jdbc.MysqlDataSource;
import sn.bachir.repository.ram.ArrayBasedDetailPrestationRepository;
import sn.bachir.repository.ram.ListBasedPrestataireRepository;
import sn.bachir.service.DisplayService;
import sn.bachir.service.MenuService;
import sn.bachir.service.console.ConsoleDisplayService;
import sn.bachir.service.console.ScannerMenuService;


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
        DetailPrestationRepository detailPrestationRepository = new ArrayBasedDetailPrestationRepository();
        DataSource dataSource = new MysqlDataSource();
        displayService = new ConsoleDisplayService(detailPrestationRepository);
        PrestationRepository prestationRepository = new JdbcBasedPrestationRepository(dataSource);
        PrestataireRepository prestataireRepository = new ListBasedPrestataireRepository();
        scannerMenuService = new ScannerMenuService(displayService, prestationRepository, prestataireRepository );
    }

    public void process(){

        displayService.afficherBienvenu();
        displayService.afficherMenuPrincipal();
        scannerMenuService.afficherMenu();
    }


}
