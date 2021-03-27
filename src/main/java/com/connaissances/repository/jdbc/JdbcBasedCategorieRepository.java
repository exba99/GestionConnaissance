package com.connaissances.repository.jdbc;

import com.connaissances.domain.Categorie;
import com.connaissances.repository.CategorieRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class  JdbcBasedCategorieRepository implements CategorieRepository {
    private final DataSource dataSource;

    public JdbcBasedCategorieRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<Categorie> listGlobalCategories = null;

    public Categorie[] getAll() {
        String query = "SELECT id, libelle FROM categorie";
        List<Categorie> categories = new ArrayList<Categorie>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String libelle = rs.getString("libelle");
                Categorie cat = new Categorie( id, libelle);

                categories.add(cat);
            }
            listGlobalCategories = categories;
            return categories.toArray(new Categorie[0]);

        }
        catch (SQLException e) {
            return new Categorie[0];
        }
        catch (Exception ex){
            return new Categorie[0];
        }

    }

    public Categorie findById(int idCat) {
        for (Categorie c: listGlobalCategories) {
            if(c.getId() == idCat) return c;
        }
        return null;
    }
}
