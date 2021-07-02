package com.isep.gorgeoussandwich.service;


import com.isep.gorgeoussandwich.dto.CommentDTO;
import com.isep.gorgeoussandwich.model.Comment;
import com.isep.gorgeoussandwich.model.Sandwich;
import com.isep.gorgeoussandwich.model.User;
import com.isep.gorgeoussandwich.repository.CommentRepository;
import com.isep.gorgeoussandwich.repository.SandwichRepository;
import com.isep.gorgeoussandwich.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private UserRepository userRepository;

    public HttpStatus addComment(CommentDTO commentDTO) {
        //Check if user exists
        Optional<User> user = this.userRepository.findById(commentDTO.getUserId());
        if(!user.isPresent()){
            throw new Error("This user does not exist");
        }

        //Check if sandwich exists
        Optional<Sandwich> sandwich = this.sandwichRepository.findById(commentDTO.getSandwichId());
        if(!sandwich.isPresent()){
            throw new Error("This sandwich does not exist");
        }

        Comment comment = new Comment(commentDTO.getDescription(),commentDTO.getSandwichId(),commentDTO.getUserId());
        commentRepository.save(comment);
        return HttpStatus.OK;
    }


    public List<CommentDTO> getAllComments(){
        List<Comment> commentList = this.commentRepository.findAll();
        List<CommentDTO> dtoList = new ArrayList<>();
        for(Comment c : commentList){
            dtoList.add(new CommentDTO(c.getDescription(),c.getSandwichId(),c.getUserId()));
        }
        return dtoList;
        //return ObjectMapperUtils.mapAll(sandwichList, SandwichDTO.class);
    }

    public HttpStatus deleteComment(long id) {
        Optional<Comment> comment = this.commentRepository.findById(id);
        if(!comment.isPresent()){
            throw new Error("This comment do not exist");
        }
        this.commentRepository.delete(comment.get());
        return HttpStatus.OK;
    }

    public List<CommentDTO> getAllCommentsOfSandwich(long sandwichId){

        //Check if sandwich exists
        Optional<Sandwich> sandwich = this.sandwichRepository.findById(sandwichId);
        if(!sandwich.isPresent()){
            throw new Error("This sandwich does not exist");
        }
        List<CommentDTO> dtoList = new ArrayList<>();
        List<Comment> listComm = this.commentRepository.findBySandwichId(sandwichId);
        for(Comment c : listComm){
            dtoList.add(new CommentDTO(c.getDescription(),c.getSandwichId(),c.getUserId()));
        }
        return dtoList;
    }



}
