package com.connaissances.repository.jdbc;

import com.connaissances.domain.Categorie;
import com.connaissances.domain.Sujet;
import com.connaissances.domain.Utilisateur;
import com.connaissances.repository.SujetRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedSujetRepository implements SujetRepository {
    private final DataSource dataSource;

    public JdbcBasedSujetRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    List<Sujet> listGlobalSujets = null;
    public Sujet[] getAllByRedacteur(Utilisateur redacteur) {
        String query = "SELECT s.id as idSujet, s.titre as titreSujet, s.description as descSujet, s.datePublication as dateSujet, s.statut as statutSujet, c.id as idCat, c.libelle as libelleCat, r.id as idRedacteur, r.nomPrenom as nomComplet, r.profil as profil, m.id as idMoniteur, m.nomPrenom as nomCompletMoniteur  FROM sujet s, categorie c, utilisateur r, utilisateur m where s.categorie=c.id AND s.moniteur=m.id AND s.redacteur="+redacteur.getId();
        List<Sujet> sujets = new ArrayList<Sujet>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("idSujet");
                String titre = rs.getString("titreSujet");
                String description = rs.getString("descSujet");
                String datePublication = rs.getString("dateSujet");
                String statut = rs.getString("statutSujet");
                Categorie cat = new Categorie( rs.getInt("idCat"), rs.getString("libelleCat"));
                Utilisateur red = new Utilisateur( rs.getInt("idRedacteur"), rs.getString("nomComplet"),rs.getString("profil"), null, null, null, true, null);
                Utilisateur moniteur = new Utilisateur( rs.getInt("idMoniteur"), rs.getString("nomCompletMoniteur"),null, null, null, null, true, null);
                Sujet sujet = new Sujet(id, titre, description, datePublication, statut, cat, moniteur, red);
                sujets.add(sujet);
            }
            listGlobalSujets = sujets;
            return sujets.toArray(new Sujet[0]);

        }
        catch (SQLException e) {
            return new Sujet[0];
        }
        catch (Exception ex){
            return new Sujet[0];
        }
    }

    public Sujet findById(int idSujet) {
        for (Sujet s: listGlobalSujets) {
            if(s.getId() == idSujet) return s;
        }
        return null;
    }
}
