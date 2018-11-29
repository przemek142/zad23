import lombok.Data;

import java.math.BigInteger;

public @Data
class Book {
    private int id;
    private String title, author;
    private String ISBN; //13cyfr


    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public Book(int id, String title, String author, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public Book() {
    }
}
