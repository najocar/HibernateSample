package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {
    private static final long serialVerisonUID =1L;

    @Id
    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AUTHOR")
    private Author author;

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Book() { }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + title + '\'' +
                ", author=" + author.getName() +
                '}';
    }
}
