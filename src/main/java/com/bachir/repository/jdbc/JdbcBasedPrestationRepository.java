package sn.bachir.repository.jdbc;


import sn.bachir.domain.Prestation;
import sn.bachir.repository.PrestationRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedPrestationRepository implements PrestationRepository {
    private final DataSource dataSource;

    public JdbcBasedPrestationRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public Prestation[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Prestation> prestations = new ArrayList<Prestation>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                //mapping retour db (relationnel) avec objet Prestation
                Prestation prestation = new Prestation( id, nom);

                prestations.add(prestation);
            }
            return prestations.toArray(new Prestation[0]);

        }
        catch (SQLException e) {
            return new Prestation[0];
        }
        catch (Exception ex){
            return new Prestation[0];
        }

    }

    public Prestation getById(int id) {
        String query = "SELECT id, nom from prestation where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int retrievedId = rs.getInt("id");
            String retrievedName = rs.getString("nom");
            Prestation prestation = new Prestation(retrievedId, retrievedName);
            return prestation;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
