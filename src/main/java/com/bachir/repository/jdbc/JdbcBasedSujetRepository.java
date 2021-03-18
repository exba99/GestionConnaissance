package sn.bachir.repository.jdbc;

import sn.bachir.domain.Categorie;
import sn.bachir.domain.Sujet;
import sn.bachir.domain.Utilisateur;
import sn.bachir.repository.SujetRepository;

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
        String query = "SELECT s.id as idSujet, s.titre as titreSujet, s.description as descSujet, s.datePublication as dateSujet, s.statut as statutSujet, c.id as idCat, c.libelle as libelleCat, r.id as idRedacteur, r.nomPrenom as nomComplet, r.profil as profil  FROM sujet s, categorie c, Utilisateur r where s.categorie.id=c.id AND s.redacteur.id="+redacteur.getId();
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
                Sujet sujet = new Sujet(id, titre, description, datePublication, statut, cat, null, red);
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
