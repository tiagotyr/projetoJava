package org.example;

import java.util.ArrayList;
import java.util.List;

public class SimulatedDatabase {
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<IssuedBook> issuedBooks = new ArrayList<>();

    public SimulatedDatabase() {
        // Adicionando alguns usuários iniciais
        users.add(new User("admin", "admin", true));
        users.add(new User("Tiago", "3276", false));
    }


    public void resetDatabase() {
        users.clear();
        books.clear();
        issuedBooks.clear();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(int bookId, int userId, String issuedDate, int period) {
        issuedBooks.add(new IssuedBook(bookId, userId, issuedDate, period));
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }
    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Retorna o usuário se as credenciais estiverem corretas
            }
        }
        return null; // Retorna null se não encontrar o usuário
    }
}
