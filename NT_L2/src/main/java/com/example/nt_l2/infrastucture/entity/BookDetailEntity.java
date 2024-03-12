package com.example.nt_l2.infrastucture.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "details", schema = "library")
public class BookDetailEntity {
    @Id
    @Column(name = "bookId")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private BookEntity bookId;

    @Column(name = "genre")
    private String genre;

    @Column(name = "summary")
    private String summary;

    @Column(name = "cover")
    private String cover;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BookEntity getBookId() {
        return bookId;
    }

    public void setBookId(BookEntity bookId) {
        this.bookId = bookId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}