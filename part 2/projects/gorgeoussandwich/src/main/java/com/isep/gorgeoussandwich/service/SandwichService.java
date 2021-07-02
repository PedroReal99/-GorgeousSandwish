package com.isep.gorgeoussandwich.service;

import com.isep.gorgeoussandwich.dto.SandwichDTO;
import com.isep.gorgeoussandwich.model.Sandwich;
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
}