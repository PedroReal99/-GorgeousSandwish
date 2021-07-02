package com.isep.gorgeoussandwich.controller;


import com.isep.gorgeoussandwich.dto.CommentDTO;
import com.isep.gorgeoussandwich.model.Comment;
import com.isep.gorgeoussandwich.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        List<CommentDTO> commentsList = commentService.getAllComments();
        return ResponseEntity.ok().body(commentsList);
    }

    @PostMapping("/comment")
    public ResponseEntity<HttpStatus> addComment(@RequestBody CommentDTO commentDto){
        return ResponseEntity.ok().body(this.commentService.addComment(commentDto));
    }

    @DeleteMapping("/comment/{id}")
    public HttpStatus deleteComment(@PathVariable long id) {
        return this.commentService.deleteComment(id);
    }

    @GetMapping("/comment/sandwich/{id}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsOfSandwich(@PathVariable long id){
        List<CommentDTO> list= commentService.getAllCommentsOfSandwich(id);
        return ResponseEntity.ok().body(list);
    }

}
