package com.example.nt_l2.service;

import com.example.nt_l2.controller.dto.loan.CreateLoanDto;
import com.example.nt_l2.controller.dto.loan.CreateLoanResponseDto;
import com.example.nt_l2.controller.dto.loan.GetLoanDto;
import com.example.nt_l2.infrastucture.entity.LoanEntity;
import com.example.nt_l2.infrastucture.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public List<GetLoanDto> getAll(){
        var loans =  loanRepository.findAll();
        return  loans.stream().map((loan) -> new GetLoanDto(loan.getId(), loan.getBookId(), loan.getUserId(), loan.getLoanDate(), loan.getDueDate(), loan.getReturnDate())).collect(Collectors.toList());
    }
    public GetLoanDto getOne(long id){
        var loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));
        return new GetLoanDto(loan.getId(), loan.getBookId(), loan.getUserId(), loan.getLoanDate(), loan.getDueDate(), loan.getReturnDate());
    }

    public CreateLoanResponseDto create(CreateLoanDto loan){
        var loanEntity = new LoanEntity();
        loanEntity.setBookId(loan.getBookId());
        loanEntity.setUserId(loan.getUserId());
        loanEntity.setLoanDate(loan.getLoanDate());
        loanEntity.setDueDate(loan.getDueDate());
        loanEntity.setReturnDate(loan.getReturnDate());
        var newLoan = loanRepository.save(loanEntity);
        return new CreateLoanResponseDto(newLoan.getId(), newLoan.getBookId(), newLoan.getUserId(), newLoan.getLoanDate(), newLoan.getDueDate(), newLoan.getReturnDate());
    }
    public void delete(long id){
        if(!loanRepository.existsById(id)){
            throw new RuntimeException();
        }
        loanRepository.deleteById(id);    }
}
