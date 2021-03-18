package sn.bachir.repository;

import sn.bachir.domain.Prestation;

public interface PrestationRepository {
    Prestation[] getAll();
    Prestation getById(int id);
}
