package com.isep.gorgeoussandwich.dto;

import com.isep.gorgeoussandwich.model.Grade;

public class ReviewDTO {

    private Grade grade;

    private long sandwichId;

    private long userId;

    public ReviewDTO(Grade grade, long sandwichId, long userId){
        this.grade=grade;
        this.sandwichId=sandwichId;
        this.userId=userId;
    }

    public Grade getGrade(){
        return grade;
    }

    public void setGrade(Grade grade){ this.grade=grade; }

    public long getSandwichId(){
        return sandwichId;
    }

    public void setSandwichId(long sandwichId){ this.sandwichId=sandwichId; }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){ this.userId=userId; }

}
