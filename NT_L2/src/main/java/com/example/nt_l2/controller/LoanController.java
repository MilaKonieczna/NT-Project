package com.example.nt_l2.controller;

import com.example.nt_l2.controller.dto.loan.CreateLoanDto;
import com.example.nt_l2.controller.dto.loan.CreateLoanResponseDto;
import com.example.nt_l2.controller.dto.loan.GetLoanDto;
import com.example.nt_l2.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<GetLoanDto> getAllLoans(){
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public GetLoanDto getOne(@PathVariable long id){
        return loanService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<CreateLoanResponseDto> create(@RequestBody CreateLoanDto loan){
        var newLoan =  loanService.create(loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        loanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

