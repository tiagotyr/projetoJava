/*package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { // Nome da classe
    public static Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/library"; // URL do banco de dados
            String user = "root"; // Usuário do banco de dados
            String password = ""; // Senha do banco de dados

            // Estabelece a conexão
            connection = DriverManager.getConnection(url, user, password);

            // Teste de conexão
            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe qualquer erro que ocorrer
        }
        return connection; // Retorna a conexão (pode ser nula se houve erro)
    }
}
*/