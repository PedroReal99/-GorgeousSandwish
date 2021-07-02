package com.isep.gorgeoussandwich.dto;

import com.isep.gorgeoussandwich.model.Description;
import com.isep.gorgeoussandwich.model.Name;

public class UserDTO {

    private Name name;

    private Description description;

    private boolean isUser;

    public UserDTO(){}

    public UserDTO(Name name, Description description, boolean isUser){
        this.name=name;
        this.description=description;
        this.isUser=isUser;
    }

    public Name getName(){
        return name;
    }

    public void setName(Name name){
        this.name=name;
    }

    public Description getDescription(){
        return description;
    }

    public void setDescription(Description description){
        this.description=description;
    }

    public boolean getIsUser(){
        return isUser;
    }

    public void setIsUser(boolean isUser){
        this.isUser=isUser;
    }

}
