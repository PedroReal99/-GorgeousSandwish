package com.isep.gorgeoussandwich.dto;

public class UserDTO {

    private String name;

    private String description;

    private boolean isUser;

    public UserDTO(){}

    public UserDTO(String name, String description, boolean isUser){
        this.name=name;
        this.description=description;
        this.isUser=isUser;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public boolean getIsUser(){
        return isUser;
    }

    public void setIsUser(boolean isUser){
        this.isUser=isUser;
    }

}
