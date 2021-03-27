package com.connaissances.repository;

import com.connaissances.domain.Commentaire;

public interface CommentaireRepository {
    Commentaire[] getAll();
    Commentaire findById(int idCommentaire);
}
