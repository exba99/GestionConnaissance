package sn.bachir.repository;

import sn.bachir.domain.Categorie;

public interface CategorieRepository {
    Categorie[] getAll();
    Categorie findById(int idCat);
}
