package com.example.nt_l2.service;

import com.example.nt_l2.controller.dto.review.CreateReviewDto;
import com.example.nt_l2.controller.dto.review.CreateReviewResponseDto;
import com.example.nt_l2.controller.dto.review.GetReviewDto;
import com.example.nt_l2.infrastucture.entity.ReviewEntity;
import com.example.nt_l2.infrastucture.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<GetReviewDto> getAll(){
        var reviews =  reviewRepository.findAll();
        return reviews.stream().map((review) -> new GetReviewDto(review.getId(), review.getBookId(), review.getUserId(), review.getRating(), review.getComment(), review.getReviewDate())).collect(Collectors.toList());    }
    public GetReviewDto getOne(long id){
        var review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        return new GetReviewDto(review.getId(), review.getBookId(), review.getUserId(), review.getRating(), review.getComment(), review.getReviewDate());
    }
    public CreateReviewResponseDto create(CreateReviewDto review){
        var reviewEntity = new ReviewEntity();
        reviewEntity.setBookId(review.getBookId());
        reviewEntity.setUserId(review.getUserId());
        reviewEntity.setComment(review.getComment());
        reviewEntity.setRating(review.getRating());
        reviewEntity.setReviewDate(review.getReviewDate());
        var newReview = reviewRepository.save(reviewEntity);
        return new CreateReviewResponseDto(newReview.getId(),newReview.getBookId(), newReview.getUserId(), newReview.getRating(), newReview.getComment(), newReview.getReviewDate());
    }
    public void delete(long id){
        if(!reviewRepository.existsById(id)){
            throw new RuntimeException();
        }
        reviewRepository.deleteById(id);    }

}
