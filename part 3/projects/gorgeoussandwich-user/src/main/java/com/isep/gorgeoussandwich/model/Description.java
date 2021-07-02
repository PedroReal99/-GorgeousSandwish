package com.isep.gorgeoussandwich.model;


public class Description {

    private String description;

    public Description(){
    }

    public Description(String description){
        if(description.isEmpty()) {
            throw new IllegalArgumentException("Description can not be empty");
        }
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }


}

