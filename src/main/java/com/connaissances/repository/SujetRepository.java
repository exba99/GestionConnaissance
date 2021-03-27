package com.connaissances.repository;

import com.connaissances.domain.Sujet;
import com.connaissances.domain.Utilisateur;

public interface SujetRepository {
    Sujet[] getAllByRedacteur(Utilisateur redacteur);
    Sujet findById(int idSujet);
}
