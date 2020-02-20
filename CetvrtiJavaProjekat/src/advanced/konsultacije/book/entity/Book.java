package advanced.konsultacije.book.entity;

import java.sql.Date;
//DTO Domain model
public class Book {

    private final Integer id;
    private final String bookName;
    private final String authorName;
    private final String publisher;
    private final Date publishingDate;

    public Book(Integer id, String bookName, String authorName, String publisher, Date publishingDate) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
    }

    public Integer getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    @Override
    public String toString() {
        return bookName + ", author: " + authorName;
    }

}
