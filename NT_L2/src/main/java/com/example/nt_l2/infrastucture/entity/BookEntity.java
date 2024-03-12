package com.example.nt_l2.infrastucture.entity;
import jakarta.persistence.*;
@Entity
@Table(name="books", schema="library")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private long bookId;

    @Basic
    @Column(name="isbn", unique = true)
    private String isbn;

    @Basic
    @Column(name="title")
    private String title;

    @Basic
    @Column(name="author")
    private String author;

    @Basic
    @Column(name="publisher")
    private String publisher;
    @Basic
    @Column(name="publicationYear")
    private int publicationYear;

    @Basic
    @Column(name="availableCopies")
    private int availableCopies;

    public long getId() {
        return bookId;
    }

    public void setId(long id) {
        this.bookId = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
