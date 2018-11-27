import lombok.Data;

public @Data class Book {
    private int id;
    private String title, author;
    private int ISBN; //13cyfr


    public Book(String title, String author, int ISBN) {
//        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public Book() {
    }
}
