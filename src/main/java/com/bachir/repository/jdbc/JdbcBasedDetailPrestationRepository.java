package sn.bachir.repository.jdbc;

import sn.bachir.domain.DetailPrestation;
import sn.bachir.repository.DetailPrestationRepository;

public class JdbcBasedDetailPrestationRepository implements DetailPrestationRepository {
    public DetailPrestation[] getAll() {
        return new DetailPrestation[0];
    }
}
