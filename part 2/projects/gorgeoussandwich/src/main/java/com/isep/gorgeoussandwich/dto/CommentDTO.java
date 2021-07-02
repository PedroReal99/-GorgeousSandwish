package com.isep.gorgeoussandwich.dto;

public class CommentDTO {

    private String description;

    private long sandwichId;

    private long userId;

    public CommentDTO(String description, long sandwichId, long userId){
        this.description=description;
        this.sandwichId=sandwichId;
        this.userId=userId;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){ this.description=description; }

    public long getSandwichId(){
        return sandwichId;
    }

    public void setSandwichId(long sandwichId){ this.sandwichId=sandwichId; }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){ this.userId=userId; }

}
