package com.example.nt_l2.service;

import com.example.nt_l2.controller.dto.book.CreateBookDto;
import com.example.nt_l2.controller.dto.book.CreateBookResponseDto;
import com.example.nt_l2.controller.dto.book.GetBookDto;
import com.example.nt_l2.controller.dto.details.CreateBookDetailDto;
import com.example.nt_l2.controller.dto.details.CreateBookDetailResponseDto;
import com.example.nt_l2.controller.dto.details.GetBookDetailDto;
import com.example.nt_l2.infrastucture.entity.BookDetailEntity;
import com.example.nt_l2.infrastucture.repository.BookDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDetailService {
    private final BookDetailRepository bookDetailRepository;

    @Autowired
    public BookDetailService(BookDetailRepository bookDetailRepository) {
        this.bookDetailRepository = bookDetailRepository;
    }

    public List<GetBookDetailDto> getAll(){
        var books =  bookDetailRepository.findAll();
        return  books.stream().map((book) -> new GetBookDetailDto(book.getId(), book.getBookId(), book.getGenre(), book.getSummary(),book.getCover())).collect(Collectors.toList());
    }
    public GetBookDetailDto getOne(long id){
        var book = bookDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return new GetBookDetailDto(book.getId(), book.getBookId(), book.getGenre(), book.getSummary(),book.getCover());
    }
    public CreateBookDetailResponseDto create(CreateBookDetailDto book){
        var bookDetailEntity = new BookDetailEntity();
        bookDetailEntity.setBookId(book.getBookId());
        bookDetailEntity.setSummary(book.getSummary());
        bookDetailEntity.setGenre(book.getGenre());
        bookDetailEntity.setCover(book.getCover());
        var newBookDetails = bookDetailRepository.save(bookDetailEntity);
        return new CreateBookDetailResponseDto(newBookDetails.getId(), newBookDetails.getBookId(), newBookDetails.getGenre(),  newBookDetails.getSummary(), newBookDetails.getCover());
    }
    public void delete(long id){
        if(!bookDetailRepository.existsById(id)){
            throw new RuntimeException();
        }
        bookDetailRepository.deleteById(id);    }
}
