package org.example;

public class User {
    private static int userCount = 0; // Contador de usuários
    private int id;
    private String username;
    private String password;
    private boolean admin;

    public User(String username, String password, boolean admin) {
        this.id = ++userCount; // Incrementa e atribui um ID único
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { // Método para obter a senha
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }
}




