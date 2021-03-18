package sn.bachir.repository;

import sn.bachir.domain.Sujet;
import sn.bachir.domain.Utilisateur;

public interface SujetRepository {
    Sujet[] getAllByRedacteur(Utilisateur redacteur);
    Sujet findById(int idSujet);
}
