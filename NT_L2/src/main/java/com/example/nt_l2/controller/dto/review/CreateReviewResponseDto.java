package com.example.nt_l2.controller.dto.review;

import com.example.nt_l2.infrastucture.entity.BookEntity;
import com.example.nt_l2.infrastucture.entity.UserEntity;

import java.util.Date;

public class CreateReviewResponseDto {
    private long id;
    private BookEntity bookId;
    private UserEntity userId;
    private int rating;
    private String comment;
    private Date reviewDate;

    public CreateReviewResponseDto() {
    }

    public CreateReviewResponseDto(long id, BookEntity bookId, UserEntity userId, int rating, String comment, Date reviewDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
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

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
