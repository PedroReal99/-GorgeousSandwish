package com.isep.gorgeoussandwich.dto;

public class ReviewDTO {

    private float grade;

    private long sandwichId;

    private long userId;

    public ReviewDTO(float grade, long sandwichId, long userId){
        this.grade=grade;
        this.sandwichId=sandwichId;
        this.userId=userId;
    }

    public float getGrade(){
        return grade;
    }

    public void setGrade(float grade){ this.grade=grade; }

    public long getSandwichId(){
        return sandwichId;
    }

    public void setSandwichId(long sandwichId){ this.sandwichId=sandwichId; }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){ this.userId=userId; }

}
