package org.example;

import java.util.ArrayList;
import java.util.List;

public class SimulatedDatabase {
    private final List<User> users = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final List<IssuedBook> issuedBooks = new ArrayList<>();

    public SimulatedDatabase() {
        users.add(new User("admin", "admin", true));
        users.add(new User("Tiago", "3276", false));
        users.add(new User("Lucas", "1696", false));
        users.add(new User("Emanuelly", "2701", false));
        users.add(new User("Nicolly", "3276", false));
        users.add(new User("Wesley", "3276", false));
        books.add(new Book("Harry Potter:Relíquias da Morte","Fantasia",59.8));
        books.add(new Book("O Conde de Monte Cristo","Aventura",85.9));
        books.add(new Book("O Pequeno Príncipe","Fantasia",49.9));
        books.add(new Book("Dom Casmurro","Romance",29.9));
        books.add(new Book("A Hora da Estrela","Drama",28.0));
        books.add(new Book("Orgulho e Preconceito","Romance",49.9));
        books.add(new Book("Os Miseráveis","Romance",39.9));
        books.add(new Book("O Rei Lear","Tragedia",29.9));
        books.add(new Book("Romeu e Julieta","Tragedia",59.90));
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
