package com.example.nt_l2.controller;

import com.example.nt_l2.controller.dto.details.CreateBookDetailDto;
import com.example.nt_l2.controller.dto.details.CreateBookDetailResponseDto;
import com.example.nt_l2.controller.dto.details.GetBookDetailDto;
import com.example.nt_l2.service.BookDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/details")
public class BookDetailController {
    private final BookDetailService bookDetailService;
    public BookDetailController(BookDetailService bookDetailService) {
        this.bookDetailService = bookDetailService;
    }

    @GetMapping
    public List<GetBookDetailDto> getAllBookDetails(){
        return bookDetailService.getAll();
    }
    @GetMapping("/{id}")
    public GetBookDetailDto getOne(@PathVariable long id){
        return bookDetailService.getOne(id);
    }
    @PostMapping
    public ResponseEntity<CreateBookDetailResponseDto> create(@RequestBody CreateBookDetailDto bookdetails){
        var newBook =  bookDetailService.create(bookdetails);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
