package com.connaissances.repository.jdbc;

import com.connaissances.domain.Categorie;
import com.connaissances.domain.Commentaire;
import com.connaissances.domain.Sujet;
import com.connaissances.domain.Utilisateur;
import com.connaissances.repository.CommentaireRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedCommentaireRepository implements CommentaireRepository {
    private final DataSource dataSource;

    public JdbcBasedCommentaireRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    List<Commentaire> listGlobalCommentaires = null;
    public Commentaire[] getAll() {
        String query = "SELECT c.id as idCom, c.dateCom as dateCom, c.description as descCom, c.etat as etatCom, s.id as idSujet, s.titre as titreSujet, u.id as idUser, u.nomPrenom as nomComplet  FROM sujet s, commentaire c, utilisateur u where c.sujet=s.id AND c.utilisateur=u.id";
        List<Commentaire> commentaires = new ArrayList<Commentaire>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("idCom");
                String dateCom = rs.getString("dateCom");
                String description = rs.getString("descCom");
                Boolean etat = rs.getBoolean("etatCom");
                Sujet s = new Sujet(rs.getInt("idSujet"), rs.getString("titreSujet"), null,null, null, null, null, null);
                Utilisateur redacteur = new Utilisateur( rs.getInt("idUser"), rs.getString("nomComplet"),null, null, null, null, true, null);
                Commentaire commentaire = new Commentaire(id,dateCom, description, etat, s, redacteur);
                commentaires.add(commentaire);
            }
            listGlobalCommentaires = commentaires;
            return commentaires.toArray(new Commentaire[0]);

        }
        catch (SQLException e) {
            return new Commentaire[0];
        }
        catch (Exception ex){
            return new Commentaire[0];
        }
    }

    public Commentaire findById(int idCommentaire) {

      for (Commentaire c: listGlobalCommentaires) {
            if(c.getId() == idCommentaire) return c;
        }
        return null;
    }
}
