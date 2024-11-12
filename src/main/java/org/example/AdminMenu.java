package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminMenu {

    private SimulatedDatabase db = new SimulatedDatabase(); // Instância da SimulatedDatabase

    public void admin_menu() {
        JFrame f = new JFrame("Funções de Administrador");

        JButton create_but = new JButton("Resetar Dados");
        create_but.setBounds(280, 60, 160, 25);
        create_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                db.resetDatabase(); // Chame o método para criar ou resetar o banco
                JOptionPane.showMessageDialog(null, "Dados Resetados!");
            }
        });

        JButton view_but = new JButton("Olhar Livros");
        view_but.setBounds(20, 20, 120, 25);
        view_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Livros Cadastrados");

                // Obter a lista de livros da SimulatedDatabase
                List<Book> books = db.getBooks();

                // Exibir os livros em uma JTable
                String[] columnNames = {"ID", "Título", "Gênero", "Preço"};
                Object[][] data = new Object[books.size()][4];

                for (int i = 0; i < books.size(); i++) {
                    data[i][0] = books.get(i).getId();
                    data[i][1] = books.get(i).getName();
                    data[i][2] = books.get(i).getGenre();
                    data[i][3] = books.get(i).getPrice();
                }

                JTable book_list = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(book_list);
                f.add(scrollPane);
                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });

        JButton users_but = new JButton("Usuários");
        users_but.setBounds(150, 20, 120, 25);
        users_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Lista de Usuários");

                // Obter a lista de usuários da SimulatedDatabase
                List<User> users = db.getUsers();

                // Exibir os usuários em uma JTable
                String[] columnNames = {"ID", "Nome", "Adm"};
                Object[][] data = new Object[users.size()][3];

                for (int i = 0; i < users.size(); i++) {
                    data[i][0] = users.get(i).getId();
                    data[i][1] = users.get(i).getUsername();
                    data[i][2] = users.get(i).isAdmin();
                }

                JTable user_list = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(user_list);
                f.add(scrollPane);
                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });

        // Botão para ver os livros emitidos
        JButton issued_but = new JButton("Livros Emprestados");
        issued_but.setBounds(280, 20, 160, 25);
        issued_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Livros Emprestados");

                // Obter a lista de livros emitidos da SimulatedDatabase
                List<IssuedBook> issuedBooks = db.getIssuedBooks();

                // Exibir os livros emitidos em uma JTable
                String[] columnNames = {"ID do Empréstimo", "ID Do Livro", "ID do Usuário", "Data do Empréstimo", "Periodo (dias)"};
                Object[][] data = new Object[issuedBooks.size()][5];

                for (int i = 0; i < issuedBooks.size(); i++) {
                    data[i][0] = issuedBooks.get(i).getIssueId();
                    data[i][1] = issuedBooks.get(i).getBookId();
                    data[i][2] = issuedBooks.get(i).getUserId();
                    data[i][3] = issuedBooks.get(i).getIssuedDate();
                    data[i][4] = issuedBooks.get(i).getPeriod();
                }

                JTable issued_list = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(issued_list);
                f.add(scrollPane);
                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });

        // Adicionar um novo usuário
        JButton add_user = new JButton("Add Usuário");
        add_user.setBounds(20, 60, 120, 25);
        add_user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame g = new JFrame("Dados do Usuário");
                JLabel l1, l2;
                l1 = new JLabel("Nome");
                l1.setBounds(30, 15, 100, 30);

                l2 = new JLabel("Senha");
                l2.setBounds(30, 50, 100, 30);

                JTextField F_user = new JTextField();
                F_user.setBounds(110, 15, 200, 30);

                JPasswordField F_pass = new JPasswordField();
                F_pass.setBounds(110, 50, 200, 30);

                JRadioButton a1 = new JRadioButton("Adm");
                a1.setBounds(55, 80, 200, 30);

                JRadioButton a2 = new JRadioButton("Usuário");
                a2.setBounds(130, 80, 200, 30);

                ButtonGroup bg = new ButtonGroup();
                bg.add(a1);
                bg.add(a2);

                JButton create_but = new JButton("Criar");
                create_but.setBounds(130, 130, 80, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = F_user.getText();
                        String password = F_pass.getText();
                        boolean admin = a1.isSelected();

                        // Adicionar o novo usuário à SimulatedDatabase
                        db.addUser(new User(username, password, admin));
                        JOptionPane.showMessageDialog(null, "Usuário Adicionado!");
                        g.dispose();
                    }
                });

                g.add(create_but);
                g.add(a2);
                g.add(a1);
                g.add(l1);
                g.add(l2);
                g.add(F_user);
                g.add(F_pass);
                g.setSize(350, 200);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        });

        // Adicionar um novo livro
        JButton add_book = new JButton("Adicionar Livro");
        add_book.setBounds(150, 60, 120, 25);
        add_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame g = new JFrame("Dados do Livro");

                JLabel l1, l2, l3;
                l1 = new JLabel("Nome do Livro");
                l1.setBounds(25, 15, 100, 30);

                l2 = new JLabel("Gênero");
                l2.setBounds(25, 53, 100, 30);

                l3 = new JLabel("Preço");
                l3.setBounds(25, 90, 100, 30);

                JTextField F_bname = new JTextField();
                F_bname.setBounds(110, 15, 200, 30);

                JTextField F_genre = new JTextField();
                F_genre.setBounds(110, 53, 200, 30);

                JTextField F_price = new JTextField();
                F_price.setBounds(110, 90, 200, 30);

                JButton create_but = new JButton("Cadastrar");
                create_but.setBounds(130, 130, 100, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String bname = F_bname.getText();
                        String genre = F_genre.getText();

                        try {
                            double price = Double.parseDouble(F_price.getText()); // Tenta converter para double

                            // Adicionar o novo livro à SimulatedDatabase
                            db.addBook(new Book(bname, genre, price)); // Verifique se o construtor de Book aceita double
                            JOptionPane.showMessageDialog(null, "Livro adicionado!");
                            g.dispose();
                        } catch (NumberFormatException ex) {
                            // Se ocorrer um erro, exibe uma mensagem
                            JOptionPane.showMessageDialog(null, "Digite um preço válido!.");
                        }
                    }
                });

                g.add(l3);
                g.add(create_but);
                g.add(l1);
                g.add(l2);
                g.add(F_bname);
                g.add(F_genre);
                g.add(F_price);
                g.setSize(350, 200);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        });

        // Emitir um livro
        JButton issue_book = new JButton("Empréstimo de Livro");
        issue_book.setBounds(450, 20, 120, 25);
        issue_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame g = new JFrame("Empréstimo de Livro");

                JLabel l1, l2, l3, l4;
                l1 = new JLabel("ID do Usuário");
                l1.setBounds(10, 15, 100, 30);

                l2 = new JLabel("ID do Livro");
                l2.setBounds(10, 50, 100, 30);

                l3 = new JLabel("Data do Empréstimo");
                l3.setBounds(10, 85, 100, 30);

                l4 = new JLabel("Período (dias)");
                l4.setBounds(10, 120, 100, 30);

                JTextField F_uid = new JTextField();
                F_uid.setBounds(110, 15, 200, 30);

                JTextField F_bid = new JTextField();
                F_bid.setBounds(110, 50, 200, 30);

                JTextField F_date = new JTextField();
                F_date.setBounds(110, 85, 200, 30);

                JTextField F_period = new JTextField();
                F_period.setBounds(110, 120, 200, 30);

                JButton create_but = new JButton("Emprestar");
                create_but.setBounds(130, 160, 100, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int uid = Integer.parseInt(F_uid.getText());
                        int bid = Integer.parseInt(F_bid.getText());
                        String issuedDate = F_date.getText();
                        int period = Integer.parseInt(F_period.getText());

                        // Emitir o livro
                        db.issueBook(bid, uid, issuedDate, period);
                        JOptionPane.showMessageDialog(null, "Livro Emprestado!");
                        g.dispose();
                    }
                });

                g.add(l1);
                g.add(l2);
                g.add(l3);
                g.add(l4);
                g.add(F_uid);
                g.add(F_bid);
                g.add(F_date);
                g.add(F_period);
                g.add(create_but);
                g.setSize(350, 220);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        });

        // Adicionar todos os botões ao JFrame
        f.add(create_but);
        f.add(view_but);
        f.add(users_but);
        f.add(issued_but);
        f.add(add_user);
        f.add(add_book);
        f.add(issue_book);

        f.setSize(600, 250);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Iniciar a interface do admin
        SwingUtilities.invokeLater(() -> {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.admin_menu();
        });
    }
}
