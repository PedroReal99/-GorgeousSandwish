package com.isep.gorgeoussandwich.dto;

import com.isep.gorgeoussandwich.model.Description;

public class CommentDTO {

    private Description description;

    private long sandwichId;

    private long userId;

    public CommentDTO(Description description, long sandwichId, long userId){
        this.description=description;
        this.sandwichId=sandwichId;
        this.userId=userId;
    }

    public Description getDescription(){
        return description;
    }

    public void setDescription(Description description){ this.description=description; }

    public long getSandwichId(){
        return sandwichId;
    }

    public void setSandwichId(long sandwichId){ this.sandwichId=sandwichId; }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){ this.userId=userId; }

}
