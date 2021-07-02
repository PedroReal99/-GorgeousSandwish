package com.isep.gorgeoussandwich.dto;


import java.util.Collection;
import java.util.List;

public class SandwichDetailsDTO {

    private SandwichDTO sandwich;

    private List<ReviewDTO> reviewList;

    private List<CommentDTO> commentList;

    public SandwichDetailsDTO(SandwichDTO sandwich, List<ReviewDTO> reviewList, List<CommentDTO> commentList){
        this.setSandwich(sandwich);
        this.setReviewList(reviewList);
        this.setCommentList(commentList);
    }

    public SandwichDetailsDTO(){

    }


    public SandwichDTO getSandwich() {
        return sandwich;
    }

    public void setSandwich(SandwichDTO sandwich) {
        this.sandwich = sandwich;
    }

    public List<ReviewDTO> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ReviewDTO> reviewList) {
        this.reviewList = reviewList;
    }

    public List<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
    }
}
