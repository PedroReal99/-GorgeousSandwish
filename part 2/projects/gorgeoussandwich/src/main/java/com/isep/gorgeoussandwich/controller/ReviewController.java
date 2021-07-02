package com.isep.gorgeoussandwich.controller;



import com.isep.gorgeoussandwich.dto.ReviewDTO;
import com.isep.gorgeoussandwich.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public ResponseEntity<List<ReviewDTO>> getAllReviews(){
        List<ReviewDTO> reviewList = reviewService.getAllReviews();
        return ResponseEntity.ok().body(reviewList);
    }

    @PostMapping("/review")
    public ResponseEntity<HttpStatus> addReview(@RequestBody ReviewDTO reviewDto){
        System.out.println("Grade:"+ reviewDto.getGrade());
        return ResponseEntity.ok().body(this.reviewService.addReview(reviewDto));
    }

    @DeleteMapping("/review/{id}")
    public HttpStatus deleteReview(@PathVariable long id) {
        return this.reviewService.deleteReview(id);
    }

    @GetMapping("/review/sandwich/{id}")
    public ResponseEntity<List<ReviewDTO>> getAllReviewsOfSandwich(@PathVariable long id){
        List<ReviewDTO> list= reviewService.getAllReviewsOfSandwich(id);
        return ResponseEntity.ok().body(list);
    }

}
