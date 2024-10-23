package org.example;

public class IssuedBook {
    private static int issueCount = 0; // Contador de empréstimos
    private int issueId;
    private int bookId;
    private int userId;
    private String issuedDate;
    private int period;

    public IssuedBook(int bookId, int userId, String issuedDate, int period) {
        this.issueId = ++issueCount; // Incrementa e atribui um ID único
        this.bookId = bookId;
        this.userId = userId;
        this.issuedDate = issuedDate;
        this.period = period;
    }

    public int getIssueId() {
        return issueId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public int getPeriod() {
        return period;
    }
}


