package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperations {

    public static void create() {
        try {
            // Conectar ao banco de dados
            Connection connection = connect();

            // Obter os catálogos de banco de dados existentes
            ResultSet resultSet = connection.getMetaData().getCatalogs();

            // Iterar sobre cada catálogo no ResultSet
            while (resultSet.next()) {
                String databaseName = resultSet.getString(1); // Nome do banco de dados na posição 1
                if (databaseName.equals("library")) {
                    Statement stmt = connection.createStatement();
                    // Drop do banco de dados se já existir
                    String sql = "DROP DATABASE library";
                    stmt.executeUpdate(sql);
                }
            }

            // Criar um novo banco de dados "library"
            Statement stmt = connection.createStatement();
            String sql = "CREATE DATABASE library";
            stmt.executeUpdate(sql);
            stmt.executeUpdate("USE library"); // Usar o banco de dados

            // Criar a tabela "USERS"
            String createUserTable = "CREATE TABLE USERS(" +
                    "UID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "USERNAME VARCHAR(30), " +
                    "PASSWORD VARCHAR(30), " +
                    "ADMIN BOOLEAN)";
            stmt.executeUpdate(createUserTable);

            // Inserir valores na tabela "USERS"
            String insertUser = "INSERT INTO USERS(USERNAME, PASSWORD, ADMIN) VALUES('admin', 'admin', TRUE)";
            stmt.executeUpdate(insertUser);

            // Criar a tabela "BOOKS"
            String createBooksTable = "CREATE TABLE BOOKS(" +
                    "BID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "BNAME VARCHAR(50), " +
                    "GENRE VARCHAR(20), " +
                    "PRICE INT)";
            stmt.executeUpdate(createBooksTable);

            // Criar a tabela "ISSUED"
            String createIssuedTable = "CREATE TABLE ISSUED(" +
                    "IID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "UID INT, " +
                    "BID INT, " +
                    "ISSUED_DATE VARCHAR(20), " +
                    "RETURN_DATE VARCHAR(20), " +
                    "PERIOD INT, " +
                    "FINE INT)";
            stmt.executeUpdate(createIssuedTable);

            // Inserir valores na tabela "BOOKS"
            String insertBooks = "INSERT INTO BOOKS(BNAME, GENRE, PRICE) VALUES " +
                    "('War and Peace', 'Mystery', 200), " +
                    "('The Guest Book', 'Fiction', 300), " +
                    "('The Perfect Murder', 'Mystery', 150), " +
                    "('Accidental Presidents', 'Biography', 250), " +
                    "('The Wicked King', 'Fiction', 350)";
            stmt.executeUpdate(insertBooks);

            // Fechar o ResultSet
            resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método connect() assumido já implementado
    public static Connection connect() {
        // Implementação do método connect() conforme o código anterior
        return null;
    }
}
