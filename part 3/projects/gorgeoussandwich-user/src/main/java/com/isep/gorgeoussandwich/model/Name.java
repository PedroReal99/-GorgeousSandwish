package com.isep.gorgeoussandwich.model;


public class Name {

    private String name;

    public Name(){
    }

    public Name(String name){
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }


}

