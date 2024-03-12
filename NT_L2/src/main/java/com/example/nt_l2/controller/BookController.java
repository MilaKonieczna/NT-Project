package com.example.nt_l2.controller;

import com.example.nt_l2.controller.dto.book.CreateBookDto;
import com.example.nt_l2.controller.dto.book.CreateBookResponseDto;
import com.example.nt_l2.controller.dto.book.GetBookDto;
import com.example.nt_l2.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<GetBookDto> getAllBooks(){
        return bookService.getAll();
    }
    @GetMapping("/{id}")
    public GetBookDto getOne(@PathVariable long id){
        return bookService.getOne(id);
    }
    @PostMapping
    public ResponseEntity<CreateBookResponseDto> create(@RequestBody CreateBookDto book){
        var newBook =  bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
