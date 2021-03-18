package sn.bachir.repository;

import sn.bachir.domain.Utilisateur;

public interface UserRepository {
    Utilisateur[] getAll();
    Utilisateur findById(int idUser);
}
