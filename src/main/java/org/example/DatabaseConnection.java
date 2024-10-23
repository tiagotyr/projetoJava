package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection connect() {
        try {
            // Carregar o driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar ao banco de dados
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=edureka");

            return con; // Retorna a conexão estabelecida
        } catch (Exception ex) {
            ex.printStackTrace(); // Exibe o stack trace caso haja uma exceção
        }
        return null; // Retorna null se houver um erro
    }
}
