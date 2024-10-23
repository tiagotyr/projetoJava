package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Para converter ResultSet em TableModel
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AdminMenu {

    public void admin_menu() {

        JFrame f = new JFrame("Admin Functions");

        JButton create_but = new JButton("Create/Reset");
        create_but.setBounds(450, 60, 120, 25);
        create_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
                JOptionPane.showMessageDialog(null, "Database Created/Reset!");
            }
        });

        JButton view_but = new JButton("View Books");
        view_but.setBounds(20, 20, 120, 25);
        view_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame f = new JFrame("Books Available");

                Connection connection = connect();
                String sql = "select * from BOOKS";
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate("USE LIBRARY");
                    ResultSet rs = stmt.executeQuery(sql);
                    JTable book_list = new JTable();
                    book_list.setModel(DbUtils.resultSetToTableModel(rs));

                    JScrollPane scrollPane = new JScrollPane(book_list);

                    f.add(scrollPane);
                    f.setSize(800, 400);
                    f.setVisible(true);
                    f.setLocationRelativeTo(null);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        JButton users_but = new JButton("View Users");
        users_but.setBounds(150, 20, 120, 25);
        users_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame f = new JFrame("Users List");

                Connection connection = connect();
                String sql = "select * from users";
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate("USE LIBRARY");
                    ResultSet rs = stmt.executeQuery(sql);
                    JTable user_list = new JTable();
                    user_list.setModel(DbUtils.resultSetToTableModel(rs));

                    JScrollPane scrollPane = new JScrollPane(user_list);

                    f.add(scrollPane);
                    f.setSize(800, 400);
                    f.setVisible(true);
                    f.setLocationRelativeTo(null);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        JButton issued_but = new JButton("View Issued Books");
        issued_but.setBounds(280, 20, 160, 25);
        issued_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame f = new JFrame("Issued Books");

                Connection connection = connect();
                String sql = "select * from issued";
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate("USE LIBRARY");
                    ResultSet rs = stmt.executeQuery(sql);
                    JTable issued_list = new JTable();
                    issued_list.setModel(DbUtils.resultSetToTableModel(rs));

                    JScrollPane scrollPane = new JScrollPane(issued_list);

                    f.add(scrollPane);
                    f.setSize(800, 400);
                    f.setVisible(true);
                    f.setLocationRelativeTo(null);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        JButton add_user = new JButton("Add User");
        add_user.setBounds(20, 60, 120, 25);
        add_user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame g = new JFrame("Enter User Details");
                JLabel l1, l2;
                l1 = new JLabel("Username");
                l1.setBounds(30, 15, 100, 30);

                l2 = new JLabel("Password");
                l2.setBounds(30, 50, 100, 30);

                JTextField F_user = new JTextField();
                F_user.setBounds(110, 15, 200, 30);

                JPasswordField F_pass = new JPasswordField();
                F_pass.setBounds(110, 50, 200, 30);

                JRadioButton a1 = new JRadioButton("Admin");
                a1.setBounds(55, 80, 200, 30);

                JRadioButton a2 = new JRadioButton("User");
                a2.setBounds(130, 80, 200, 30);

                ButtonGroup bg = new ButtonGroup();
                bg.add(a1);
                bg.add(a2);

                JButton create_but = new JButton("Create");
                create_but.setBounds(130, 130, 80, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String username = F_user.getText();
                        String password = F_pass.getText();
                        boolean admin = a1.isSelected();

                        Connection connection = connect();

                        try {
                            Statement stmt = connection.createStatement();
                            stmt.executeUpdate("USE LIBRARY");
                            stmt.executeUpdate("INSERT INTO USERS(USERNAME,PASSWORD,ADMIN) VALUES ('" + username + "','" + password + "'," + admin + ")");
                            JOptionPane.showMessageDialog(null, "User added!");
                            g.dispose();

                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1);
                        }
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

        JButton add_book = new JButton("Add Book");
        add_book.setBounds(150, 60, 120, 25);
        add_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame g = new JFrame("Enter Book Details");

                JLabel l1, l2, l3;
                l1 = new JLabel("Book Name");
                l1.setBounds(30, 15, 100, 30);

                l2 = new JLabel("Genre");
                l2.setBounds(30, 53, 100, 30);

                l3 = new JLabel("Price");
                l3.setBounds(30, 90, 100, 30);

                JTextField F_bname = new JTextField();
                F_bname.setBounds(110, 15, 200, 30);

                JTextField F_genre = new JTextField();
                F_genre.setBounds(110, 53, 200, 30);

                JTextField F_price = new JTextField();
                F_price.setBounds(110, 90, 200, 30);

                JButton create_but = new JButton("Submit");
                create_but.setBounds(130, 130, 80, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String bname = F_bname.getText();
                        String genre = F_genre.getText();
                        int price = Integer.parseInt(F_price.getText());

                        Connection connection = connect();

                        try {
                            Statement stmt = connection.createStatement();
                            stmt.executeUpdate("USE LIBRARY");
                            stmt.executeUpdate("INSERT INTO BOOKS(BNAME,GENRE,PRICE) VALUES ('" + bname + "','" + genre + "'," + price + ")");
                            JOptionPane.showMessageDialog(null, "Book added!");
                            g.dispose();

                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1);
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

        JButton issue_book = new JButton("Issue Book");
        issue_book.setBounds(450, 20, 120, 25);
        issue_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame g = new JFrame("Enter Details");

                JLabel l1, l2, l3, l4;
                l1 = new JLabel("Book ID(BID)");
                l1.setBounds(30, 15, 100, 30);

                l2 = new JLabel("User ID(UID)");
                l2.setBounds(30, 53, 100, 30);

                l3 = new JLabel("Period(days)");
                l3.setBounds(30, 90, 100, 30);

                l4 = new JLabel("Issued Date(DD-MM-YYYY)");
                l4.setBounds(30, 127, 150, 30);

                JTextField F_bid = new JTextField();
                F_bid.setBounds(110, 15, 200, 30);

                JTextField F_uid = new JTextField();
                F_uid.setBounds(110, 53, 200, 30);

                JTextField F_period = new JTextField();
                F_period.setBounds(110, 90, 200, 30);

                JTextField F_issue = new JTextField();
                F_issue.setBounds(180, 130, 130, 30);

                JButton create_but = new JButton("Submit");
                create_but.setBounds(130, 170, 80, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        int uid = Integer.parseInt(F_uid.getText());
                        int bid = Integer.parseInt(F_bid.getText());
                        int period = Integer.parseInt(F_period.getText());
                        String issued_date = F_issue.getText();

                        Connection connection = connect();

                        try {
                            Statement stmt = connection.createStatement();
                            stmt.executeUpdate("USE LIBRARY");
                            stmt.executeUpdate("INSERT INTO ISSUED(BID,UID,ISSUED_DATE,PERIOD) VALUES (" + bid + "," + uid + ",'" + issued_date + "'," + period + ")");
                            JOptionPane.showMessageDialog(null, "Book Issued!");
                            g.dispose();

                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1);
                        }
                    }
                });

                g.add(l4);
                g.add(create_but);
                g.add(l1);
                g.add(l2);
                g.add(l3);
                g.add(F_uid);
                g.add(F_bid);
                g.add(F_period);
                g.add(F_issue);
                g.setSize(350, 250);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        });

        JButton return_book = new JButton("Return Book");
        return_book.setBounds(300, 60, 120, 25);
        return_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame g = new JFrame("Enter Details");

                JLabel l1, l2;
                l1 = new JLabel("Issue ID(IID)");
                l1.setBounds(30, 15, 100, 30);

                l2 = new JLabel("Return Date(DD-MM-YYYY)");
                l2.setBounds(30, 53, 150, 30);

                JTextField F_iid = new JTextField();
                F_iid.setBounds(110, 15, 200, 30);

                JTextField F_return = new JTextField();
                F_return.setBounds(180, 53, 130, 30);

                JButton create_but = new JButton("Return");
                create_but.setBounds(130, 170, 80, 25);
                create_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        int iid = Integer.parseInt(F_iid.getText());
                        String return_date = F_return.getText();
                        Connection connection = connect();

                        try {
                            Statement stmt = connection.createStatement();
                            stmt.executeUpdate("USE LIBRARY");

                            ResultSet rs = stmt.executeQuery("SELECT ISSUED_DATE, PERIOD FROM ISSUED WHERE IID=" + iid);
                            if (rs.next()) {
                                String issued_date = rs.getString(1);
                                int period = rs.getInt(2);

                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                                Date date_1 = sdf.parse(issued_date);
                                Date date_2 = sdf.parse(return_date);

                                long diff = date_2.getTime() - date_1.getTime();
                                int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

                                if (days > period) {
                                    int fine = (days - period) * 10;
                                    JOptionPane.showMessageDialog(null, "The fine is: $" + fine);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Book returned on time!");
                                }

                                stmt.executeUpdate("DELETE FROM ISSUED WHERE IID=" + iid);
                                JOptionPane.showMessageDialog(null, "Book Returned!");
                                g.dispose();

                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Issue ID");
                            }
                        } catch (SQLException | ParseException e1) {
                            JOptionPane.showMessageDialog(null, e1);
                        }
                    }
                });

                g.add(l2);
                g.add(create_but);
                g.add(l1);
                g.add(F_iid);
                g.add(F_return);
                g.setSize(350, 250);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        });

        f.add(issue_book);
        f.add(view_but);
        f.add(users_but);
        f.add(issued_but);
        f.add(add_user);
        f.add(add_book);
        f.add(return_book);
        f.add(create_but);

        f.setSize(600, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void create() {
        try {
            Connection connection = connect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS LIBRARY");
            stmt.executeUpdate("USE LIBRARY");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS USERS(UID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(30), PASSWORD VARCHAR(30), ADMIN BOOLEAN)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS BOOKS(BID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, BNAME VARCHAR(100), GENRE VARCHAR(30), PRICE INT)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ISSUED(IID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, BID INT, UID INT, ISSUED_DATE VARCHAR(20), PERIOD INT, FOREIGN KEY (BID) REFERENCES BOOKS(BID), FOREIGN KEY (UID) REFERENCES USERS(UID))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdminMenu().admin_menu();
    }
}
