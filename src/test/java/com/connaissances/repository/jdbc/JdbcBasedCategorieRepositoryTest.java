package com.connaissances.repository.jdbc;

import com.connaissances.domain.Categorie;
import com.connaissances.repository.CategorieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JdbcBasedCategorieRepositoryTest {
    private JdbcBasedCategorieRepository jdbcBasedCategorieRepository;
    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new MockDatasource();
        jdbcBasedCategorieRepository = new JdbcBasedCategorieRepository(dataSource);
    }

    @Test
    void getAll() {
        System.out.println("Dans la méthode getAll categorie");
        //Act
        Categorie[] categories = jdbcBasedCategorieRepository.getAll();
        //Assert
        assertEquals(2, categories.length, "le nombre de categorie doit être 2");
    }

    @Test
    void findById() {
        Categorie categorie = jdbcBasedCategorieRepository.findById(1);
        assertNotNull(categorie);
        assertEquals(1, categorie.getId());
        assertEquals("INFORMATIQUE", categorie.getLibelle());
    }
}