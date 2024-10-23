package org.example;

public class Book {
    private static int bookCount = 0; // Contador de livros
    private int id;
    private String name;
    private String genre;
    private double price;

    public Book(String name, String genre, double price) {
        this.id = ++bookCount; // Incrementa e atribui um ID único
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }
}


