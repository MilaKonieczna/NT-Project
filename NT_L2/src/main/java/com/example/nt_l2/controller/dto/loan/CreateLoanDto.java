package com.example.nt_l2.controller.dto.loan;

import com.example.nt_l2.infrastucture.entity.BookEntity;
import com.example.nt_l2.infrastucture.entity.UserEntity;

import java.util.Date;

public class CreateLoanDto {
    private BookEntity bookId;
    private UserEntity userId;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;

    public CreateLoanDto() {
    }

    public CreateLoanDto(BookEntity bookId, UserEntity userId, Date loanDate, Date dueDate, Date returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
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

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
