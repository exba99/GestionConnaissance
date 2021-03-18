package sn.bachir.repository;

import sn.bachir.domain.Commentaire;

public interface CommentaireRepository {
    Commentaire[] getAll();
    Commentaire findById(int idCommentaire);
}
