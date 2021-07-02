package com.isep.gorgeoussandwich.model;

import javax.persistence.*;


@Entity
@Table(name="sandwich")
public class Sandwich{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "designation")
    @Embedded
	private Designation designation;

    //@Column(name = "description")
    @Embedded
    private Description description;

    //@Column(name = "type")
    @Embedded
    private Type type;

    public Sandwich(){
    }
    public Sandwich(Designation designation,Description description,Type type){
        this.designation=designation;
        this.description=description;
        this.type=type;
    }

    public Designation getDesignation(){
        return designation;
    }

    public void setDesignation(Designation designation){
        this.designation=designation;
    }

    public Description getDescription(){
        return description;
    }

    public void setDescription(Description description){
        this.description=description;
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type){ this.type=type; }

    public long getId(){
        return id;
    }

    public void setSandwichId(long sandwichId) {
        this.id = id;
    }

}