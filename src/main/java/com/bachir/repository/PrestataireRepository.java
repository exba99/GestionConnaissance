package sn.bachir.repository;

import sn.bachir.domain.Prestataire;
import sn.bachir.domain.Prestation;

public interface PrestataireRepository {
    Prestataire[] getAllByPrestation(Prestation prestation);
    Prestataire findById(int idPrestataire);
}
