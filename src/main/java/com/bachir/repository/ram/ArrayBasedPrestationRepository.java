package sn.bachir.repository.ram;

import sn.bachir.domain.Prestation;
import sn.bachir.repository.PrestationRepository;

public class ArrayBasedPrestationRepository implements PrestationRepository {

    public static final Prestation[] PRESTATIONS = {
            new Prestation(1, "Coursier"),
            new Prestation(2, "Nettoyage"),
            new Prestation(3, "Tutorat"),
            new Prestation(4, "Traiteur"),
    };

    public Prestation[] getAll(){
        return PRESTATIONS;
    }

    public Prestation getById(int id){
        Prestation prestation;
        for (int i = 0; i < PRESTATIONS.length; i++) {
            if(id == PRESTATIONS[i].getId()){
                return PRESTATIONS[i];
            }
        }
        return null;
    }
}
