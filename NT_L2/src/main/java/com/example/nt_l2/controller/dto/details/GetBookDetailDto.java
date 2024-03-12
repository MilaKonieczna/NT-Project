package com.example.nt_l2.controller.dto.details;

import com.example.nt_l2.infrastucture.entity.BookEntity;

public class GetBookDetailDto {
    private long id;
    private BookEntity bookId;
    private String genre;
    private String summary;
    private String cover;

    public GetBookDetailDto() {
    }

    public GetBookDetailDto(long id, BookEntity bookId, String genre, String summary, String cover) {
        this.id = id;
        this.bookId = bookId;
        this.genre = genre;
        this.summary = summary;
        this.cover = cover;
    }

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
