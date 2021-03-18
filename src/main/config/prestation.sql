CREATE TABLE prestation(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(255) NOT NULL
);


INSERT INTO prestation(nom)
    VALUES
      ('Nettoyage'),
      ('Coursier'),
      ('Tutorat'),
      ('Ménage');
