package sn.bachir.repository.jdbc;

import sn.bachir.domain.Prestataire;
import sn.bachir.domain.Prestation;
import sn.bachir.repository.PrestataireRepository;

public class JdbcBasedPrestataireRepository implements PrestataireRepository {
    public Prestataire[] getAllByPrestation(Prestation prestation) {
        return new Prestataire[0];
    }

    public Prestataire findById(int idPrestataire) {
        return null;
    }
}
