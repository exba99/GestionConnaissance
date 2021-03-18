package sn.bachir.repository.ram;

import sn.bachir.domain.Categorie;
import sn.bachir.domain.Prestation;
import sn.bachir.repository.CategorieRepository;

public class ArrayBasedCategorieRepository implements CategorieRepository {
    public static final Categorie[] CATEGORIES = {
            new Categorie(1, "Programmation"),
            new Categorie(2, "Reseau"),
            new Categorie(3, "Medcine"),
    };

    public Categorie[] getAll() {
        return CATEGORIES;
    }

    public Categorie findById(int idCat) {
        for (Categorie c: CATEGORIES) {
            if(c.getId() == idCat) return c;
        }
        return null;
    }
}
