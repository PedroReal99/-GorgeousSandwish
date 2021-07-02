package com.isep.gorgeoussandwich.controller;

import com.isep.gorgeoussandwich.dto.SandwichDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.isep.gorgeoussandwich.model.Sandwich;
import com.isep.gorgeoussandwich.service.SandwichService;
import com.isep.gorgeoussandwich.dto.SandwichDTO;

import java.util.List;


@RestController
public class SandwichController{

    @Autowired
    private SandwichService sandwichService;

    @GetMapping("/sandwich")
    public ResponseEntity<List<SandwichDTO>> getAllSandwichs(){
        List<SandwichDTO> sandwichList = sandwichService.getAllSandwichs();
        return ResponseEntity.ok().body(sandwichList);
    }

    @PostMapping("/sandwich")
    public ResponseEntity<HttpStatus> addSandwich(@RequestBody SandwichDTO sandwichDto){
        System.out.println("Controller:"+sandwichDto.getType());
        return ResponseEntity.ok().body(this.sandwichService.addSandwich(sandwichDto));
    }

    @GetMapping("/sandwich/{id}")
    public ResponseEntity<SandwichDTO> getSandwichById(@PathVariable long id){
        SandwichDTO sandwichDTO = sandwichService.getSandwichById(id);
        return ResponseEntity.ok().body(sandwichDTO);
    }

    @DeleteMapping("/sandwich/{id}")
    public HttpStatus deleteSandwich(@PathVariable long id) {
        return this.sandwichService.deleteSandwich(id);
    }

    @GetMapping("/sandwich/details/{id}")
    public ResponseEntity<SandwichDetailsDTO> getSandwichDetailsById(@PathVariable long id){
        SandwichDetailsDTO sandwichDetailsDTO = sandwichService.getSandwichDetailsById(id);
        return ResponseEntity.ok().body(sandwichDetailsDTO);
    }

}