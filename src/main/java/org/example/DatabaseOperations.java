/*package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {

    public static void create() {
        String url = "jdbc:mysql://localhost:3306/library"; // URL do banco de dados
        String user = "root"; // Usuário do banco de dados
        String password = ""; // Senha do banco de dados

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement stmt = connection.createStatement()) {

            // Verifica se o banco de dados já existe
            ResultSet resultSet = connection.getMetaData().getCatalogs();
            while (resultSet.next()) {
                String databaseName = resultSet.getString(1); // Nome do banco de dados na posição 1
                if (databaseName.equals("library")) {
                    // Drop do banco de dados se já existir
                    stmt.executeUpdate("DROP DATABASE library");
                    break; // Sai do loop se o banco de dados for encontrado e removido
                }
            }
            resultSet.close(); // Fechar ResultSet após uso

            // Criar um novo banco de dados "library"
            stmt.executeUpdate("CREATE DATABASE library");

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

            System.out.println("Banco de dados e tabelas criados com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace(); // Exibe qualquer erro que ocorrer
        }
    }

    public static Connection connect() {
        // Aqui você pode incluir a implementação do método connect() se necessário
        return null; // Remova ou implemente conforme necessário
    }
}*/
