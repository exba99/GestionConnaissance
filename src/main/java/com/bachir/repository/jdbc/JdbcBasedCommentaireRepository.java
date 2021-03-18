package sn.bachir.repository.jdbc;

import sn.bachir.domain.Commentaire;
import sn.bachir.repository.CommentaireRepository;

public class JdbcBasedCommentaireRepository implements CommentaireRepository {
    public Commentaire[] getAll() {
        return new Commentaire[0];
    }

    public Commentaire findById(int idCommentaire) {
        return null;
    }
}
