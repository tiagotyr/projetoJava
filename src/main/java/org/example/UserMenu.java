package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; // Importando List
import java.util.ArrayList; // Importando ArrayList


public class UserMenu {

    public static void user_menu(String UID) {
        JFrame f = new JFrame("Funções de Usuário"); // Criar JFrame com o título "User Functions"

        // Botão para visualizar os livros
        JButton view_but = new JButton("Olhar Livros"); // Criar botão para "View Books"
        view_but.setBounds(20, 20, 120, 25); // Definir posição e tamanho do botão
        view_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame bookFrame = new JFrame("Livros Cadastrados"); // Criar nova janela para exibir os livros

                // Aqui você deve adicionar código para obter os livros da SimulatedDatabase
                List<Book> books = new SimulatedDatabase().getBooks(); // Obtenha a lista de livros

                // Exibir os livros em uma JTable
                String[] columnNames = {"ID", "Título", "Gênero", "Preço"};
                Object[][] data = new Object[books.size()][4];

                for (int i = 0; i < books.size(); i++) {
                    data[i][0] = books.get(i).getId();
                    data[i][1] = books.get(i).getName();
                    data[i][2] = books.get(i).getGenre();
                    data[i][3] = books.get(i).getPrice();
                }

                JTable book_list = new JTable(data, columnNames); // Criar tabela para exibir os livros
                JScrollPane scrollPane = new JScrollPane(book_list); // Adicionar barra de rolagem
                bookFrame.add(scrollPane); // Adicionar a tabela à janela

                bookFrame.setSize(800, 400); // Definir o tamanho da janela
                bookFrame.setVisible(true); // Tornar a janela visível
                bookFrame.setLocationRelativeTo(null); // Centralizar a janela
                bookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
            }
        });

        // Botão para visualizar os livros do usuário
        JButton my_book = new JButton("Meus Livros"); // Criar botão para "My Books"
        my_book.setBounds(150, 20, 120, 25); // Definir posição e tamanho do botão
        my_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você deve implementar a lógica para visualizar os livros do usuário
                JOptionPane.showMessageDialog(f, "Atualização não implementada ainda!"); // Placeholder
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
}
