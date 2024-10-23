package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    private SimulatedDatabase db = new SimulatedDatabase(); // Usando o banco de dados simulado

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().createLoginWindow()); // Chama o método para criar a janela de login
    }

    public void createLoginWindow() {
        JFrame f = new JFrame("Entrar");

        JLabel l1 = new JLabel("Úsuario");
        l1.setBounds(30, 15, 100, 30);

        JLabel l2 = new JLabel("Senha");
        l2.setBounds(30, 50, 100, 30);

        JTextField F_user = new JTextField();
        F_user.setBounds(110, 15, 200, 30);

        JPasswordField F_pass = new JPasswordField();
        F_pass.setBounds(110, 50, 200, 30);

        JButton login_but = new JButton("Entrar");
        login_but.setBounds(130, 90, 80, 25);

        login_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = F_user.getText();
                String password = new String(F_pass.getPassword());

                if (username.equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite seu Nome");
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite sua Senha");
                } else {
                    User user = db.authenticate(username, password); // Usando a base simulada
                    if (user == null) {
                        JOptionPane.showMessageDialog(null, "Senha Incorreta!");
                    } else {
                        f.dispose(); // Fechar a janela de login
                        if (user.isAdmin()) {
                            new AdminMenu().admin_menu(); // Se for admin, instanciar AdminMenu e chamar admin_menu
                        } else {
                            UserMenu.user_menu(String.valueOf(user.getId())); // Chama o menu de usuário
                        }
                    }
                }
            }
        });

        f.add(F_user);
        f.add(F_pass);
        f.add(login_but);
        f.add(l1);
        f.add(l2);

        f.setSize(400, 180);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Adicionando fechamento da aplicação
    }
}
