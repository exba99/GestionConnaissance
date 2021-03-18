package sn.bachir.repository.ram;

import sn.bachir.domain.DetailPrestation;
import sn.bachir.repository.DetailPrestationRepository;

public class ArrayBasedDetailPrestationRepository implements DetailPrestationRepository {
    public DetailPrestation[] getAll(){
        return new DetailPrestation[]{
                new DetailPrestation(1, "Course Rufisque", 500),
                new DetailPrestation(2, "Course Pikine", 1500),
                new DetailPrestation(3, "Course Dakar", 2500),
        };
    }
}
