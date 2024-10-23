package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class UserMenu {

    public static void user_menu(String UID) {
        JFrame f = new JFrame("User Functions"); // Criar JFrame com o título "User Functions"

        // Botão para visualizar os livros
        JButton view_but = new JButton("View Books"); // Criar botão para "View Books"
        view_but.setBounds(20, 20, 120, 25); // Definir posição e tamanho do botão
        view_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Books Available"); // Criar nova janela para exibir os livros

                Connection connection = connect(); // Conectar ao banco de dados
                String sql = "SELECT * FROM BOOKS"; // Consulta para obter todos os livros

                try {
                    Statement stmt = connection.createStatement(); // Criar a conexão
                    stmt.executeUpdate("USE LIBRARY"); // Selecionar o banco de dados "LIBRARY"
                    ResultSet rs = stmt.executeQuery(sql); // Executar a consulta

                    JTable book_list = new JTable(); // Criar tabela para exibir os livros
                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); // Usar o utilitário DbUtils para popular a tabela com o ResultSet

                    JScrollPane scrollPane = new JScrollPane(book_list); // Adicionar barra de rolagem
                    f.add(scrollPane); // Adicionar a tabela à janela

                    f.setSize(800, 400); // Definir o tamanho da janela
                    f.setVisible(true); // Tornar a janela visível
                    f.setLocationRelativeTo(null); // Centralizar a janela
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1); // Mostrar erro em caso de falha na consulta
                }
            }
        });

        // Botão para visualizar os livros do usuário
        JButton my_book = new JButton("My Books"); // Criar botão para "My Books"
        my_book.setBounds(150, 20, 120, 25); // Definir posição e tamanho do botão
        my_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("My Books"); // Criar nova janela para exibir os livros do usuário

                int UID_int = Integer.parseInt(UID); // Converter UID para int
                Connection connection = connect(); // Conectar ao banco de dados
                String sql = "SELECT DISTINCT issued.*, books.bname, books.genre, books.price " +
                        "FROM issued, books " +
                        "WHERE ((issued.uid = " + UID_int + ") AND (books.bid IN " +
                        "(SELECT bid FROM issued WHERE issued.uid = " + UID_int + "))) GROUP BY iid"; // Consulta para obter os livros emitidos pelo usuário

                try {
                    Statement stmt = connection.createStatement(); // Criar a conexão
                    stmt.executeUpdate("USE LIBRARY"); // Selecionar o banco de dados "LIBRARY"

                    ResultSet rs = stmt.executeQuery(sql); // Executar a consulta

                    JTable book_list = new JTable(); // Criar tabela para exibir os livros emitidos
                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); // Usar o utilitário DbUtils para popular a tabela com o ResultSet

                    JScrollPane scrollPane = new JScrollPane(book_list); // Adicionar barra de rolagem
                    f.add(scrollPane); // Adicionar a tabela à janela

                    f.setSize(800, 400); // Definir o tamanho da janela
                    f.setVisible(true); // Tornar a janela visível
                    f.setLocationRelativeTo(null); // Centralizar a janela
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1); // Mostrar erro em caso de falha na consulta
                }
            }
        });

        // Adicionar os botões à janela principal
        f.add(view_but);
        f.add(my_book);

        // Configurações da janela principal
        f.setSize(300, 100); // Definir tamanho da janela
        f.setLayout(null); // Usar layout nulo (sem gerenciador de layout)
        f.setVisible(true); // Tornar a janela visível
        f.setLocationRelativeTo(null); // Centralizar a janela
    }

    // Método para conectar ao banco de dados (implementação suposta)
    public static Connection connect() {
        // Implementar a conexão com o banco de dados
        return null;
    }
}
