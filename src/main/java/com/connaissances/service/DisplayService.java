package com.connaissances.service;

import com.connaissances.domain.Commentaire;
import com.connaissances.domain.Sujet;

public interface DisplayService {
    void afficherBienvenu();

    void afficherMenuPrincipal();

    void afficherListeCommentaire(Commentaire[] commentaires);

    void afficherUnCommentaire(Commentaire commentaire);

    void afficherListeSujetByUser(Sujet[] sujets);


    void afficherOptionInconnue();
}
