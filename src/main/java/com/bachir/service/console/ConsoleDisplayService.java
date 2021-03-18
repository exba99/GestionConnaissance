package sn.bachir.service.console;

import sn.bachir.domain.DetailPrestation;
import sn.bachir.domain.Prestataire;
import sn.bachir.domain.Prestation;
import sn.bachir.repository.DetailPrestationRepository;
import sn.bachir.service.DisplayService;

public class ConsoleDisplayService implements DisplayService {

    private final DetailPrestationRepository detailPrestationRepository;

    public ConsoleDisplayService(DetailPrestationRepository detailPrestationRepository) {
        this.detailPrestationRepository = detailPrestationRepository;
    }

    public void afficherBienvenu() {
        System.out.println("Bienvenu sur la plateforme service à la demande!");
    }

    public void afficherMenuPrincipal() {
        System.out.println("> l pour lister les services disponibles ");
    }

    public void afficherListeServices(Prestation[] prestations) {
        System.out.println("Les services disponibles sont:");
        for (int i = 0; i < prestations.length; i++) {
            Prestation prestation = prestations[i];
            System.out.println(String.format("> %s %s", prestation.getId(), prestation.getNom()));
        }
    }

    public void afficherPrestataires(Prestation prestation, Prestataire[] prestataires) {
        System.out.println(String.format("La liste des prestataires %s :", prestation.getNom()));
        for (int i = 0; i < prestataires.length; i++) {
            Prestataire prestataire = prestataires[i];
            System.out.println(String.format("> %s %s %s", prestataire.getId(), prestataire.getPrenom(), prestataire.getNom()));
        }
    }

    public void afficherDetailsPrestation() {
        System.out.println("Les détails des prestations de Alassane Sene : ");
        DetailPrestation[] detailPrestations = detailPrestationRepository.getAll();
        for (int i = 0; i <detailPrestations.length; i++) {
            DetailPrestation detailPrestation = detailPrestations[i];
            System.out.println(
                    String.format(
                            "> %s %s : %s",
                            detailPrestation.getId(),
                            detailPrestation.getDetails(),
                            detailPrestation.getPrix()
                    )
            );
        }
    }

    public void afficherDetailsContrat() {
        System.out.println("Prestation Alassane Sene: Course Dakar 2500 ");
    }

    public void afficherDemandeHeure() {
        System.out.println("Quelle heure voulez-vous (hh:mm) ?");
    }

    public void afficherConfirmation(String heure) {
        System.out.println(String.format("OK pour %s", heure));
    }

    public void afficherOptionInconnue() {
        System.out.println("Choix inconnu");
    }
}
