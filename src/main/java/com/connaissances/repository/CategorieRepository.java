package com.connaissances.repository;

import com.connaissances.domain.Categorie;

public interface CategorieRepository {
    Categorie[] getAll();
    Categorie findById(int idCat);
}
