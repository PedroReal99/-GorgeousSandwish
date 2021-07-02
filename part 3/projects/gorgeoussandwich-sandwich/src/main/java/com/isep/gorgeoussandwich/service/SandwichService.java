package com.isep.gorgeoussandwich.service;

import com.isep.gorgeoussandwich.dto.CommentDTO;
import com.isep.gorgeoussandwich.dto.ReviewDTO;
import com.isep.gorgeoussandwich.dto.SandwichDTO;
import com.isep.gorgeoussandwich.dto.SandwichDetailsDTO;
import com.isep.gorgeoussandwich.model.Comment;
import com.isep.gorgeoussandwich.model.Review;
import com.isep.gorgeoussandwich.model.Sandwich;
import com.isep.gorgeoussandwich.repository.CommentRepository;
import com.isep.gorgeoussandwich.repository.ReviewRepository;
import com.isep.gorgeoussandwich.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SandwichService{

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<SandwichDTO> getAllSandwichs(){
        List<Sandwich> sandwichList = this.sandwichRepository.findAll();
        List<SandwichDTO> dtoList = new ArrayList<>();
        System.out.println("GET:"+sandwichList.get(0).getId());
        for(Sandwich sand : sandwichList){
            dtoList.add(new SandwichDTO(sand.getId(),sand.getDesignation(),sand.getDescription(),sand.getType()));
        }
        return dtoList;
    }

    public HttpStatus addSandwich(SandwichDTO sandwichDTO) {
        System.out.println("DTO:"+sandwichDTO.getDesignation());
        Sandwich sandwich = new Sandwich(sandwichDTO.getDesignation(),sandwichDTO.getDescription(),sandwichDTO.getType());
        System.out.println(sandwich.getDesignation());
        sandwichRepository.save(sandwich);
        return HttpStatus.OK;
    }

    public SandwichDTO getSandwichById(long sandwichId) {
        Optional<Sandwich> sandwichDB = this.sandwichRepository.findById(sandwichId);
        if (sandwichDB.isPresent()) {
            return new SandwichDTO(sandwichDB.get().getDesignation(),sandwichDB.get().getDescription(),sandwichDB.get().getType());
        } else {
            System.out.println("Error!! Sandwich not found");
            return null;
            //throw new ResourceNotFoundException("Sandes not found with id : " + sandesId);
        }
    }

    public HttpStatus deleteSandwich(long id) {
        Optional<Sandwich> sandwich = this.sandwichRepository.findById(id);
        if(!sandwich.isPresent()){
            throw new Error("This sandwich do not exist");
        }
        this.sandwichRepository.delete(sandwich.get());
        return HttpStatus.OK;
    }

    public SandwichDetailsDTO getSandwichDetailsById(long id){
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        SandwichDTO sandwich = getSandwichById(id);
        sandwich.setSandwichId(id);
        List<Review> reviewList = reviewRepository.findBySandwichId(id);
        for(Review r : reviewList){
            reviewDTOList.add(new ReviewDTO(r.getGrade(),r.getSandwichId(),r.getUserId()));
        }
        List<Comment> commentList = commentRepository.findBySandwichId(id);
        for(Comment c : commentList){
            commentDTOList.add(new CommentDTO(c.getDescription(),c.getSandwichId(),c.getUserId()));
        }
        return new SandwichDetailsDTO(sandwich,reviewDTOList,commentDTOList);
    }

}