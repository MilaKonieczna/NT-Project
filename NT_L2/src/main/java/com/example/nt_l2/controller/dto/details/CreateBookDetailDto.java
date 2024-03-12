package com.example.nt_l2.controller.dto.details;

import com.example.nt_l2.infrastucture.entity.BookEntity;

public class CreateBookDetailDto {
    private BookEntity bookId;
    private String genre;
    private String summary;
    private String cover;

    public CreateBookDetailDto() {
    }

    public CreateBookDetailDto(BookEntity bookId, String genre, String summary, String cover) {
        this.bookId = bookId;
        this.genre = genre;
        this.summary = summary;
        this.cover = cover;
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
