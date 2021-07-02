package com.isep.gorgeoussandwich.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="sandwich")
public class Sandwich{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "designation")
	private String designation;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    public Sandwich(){
    }
    public Sandwich(String designation,String description,String type){
        this.designation=designation;
        this.description=description;
        this.type=type;
    }

    public String getDesignation(){
        return designation;
    }

    public void setDesignation(String designation){
        this.designation=designation;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){ this.type=type; }

    public long getId(){
        return id;
    }

    public void setSandwichId(long sandwichId) {
        this.id = id;
    }

}