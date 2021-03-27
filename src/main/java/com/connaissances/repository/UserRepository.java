package com.connaissances.repository;

import com.connaissances.domain.Utilisateur;

public interface UserRepository {
    Utilisateur[] getAll();
    Utilisateur findById(int idUser);
}
