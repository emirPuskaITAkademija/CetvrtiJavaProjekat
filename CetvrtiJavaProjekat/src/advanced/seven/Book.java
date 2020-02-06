package advanced.seven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private static int autoIncrement = 0;
    private int isbn;
    private List<String> authors = new ArrayList<>();
    private String title;
    private LocalDate publishDate;

    private Book(int isbn, String author, String title){
        this.isbn = isbn;
        this.authors.add(author);
        this.title = title;
    }

    private Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.authors.add(author);
        this.publishDate = publishDate;
        autoIncrement++;
    }
    
    
    
    public int getIsbn() {
        return isbn;
    }
 
    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    
    //SFM
    public static Book of(int isbn, String author, String title){
        return new Book(isbn, author, title);
    }
    
    
    public static Book withoutIsbn(String title, String author, LocalDate publishDate){
        Book book = new Book(title, author, publishDate);
        book.isbn = autoIncrement;
        return book;
    }
}
