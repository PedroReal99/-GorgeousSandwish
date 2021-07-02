package com.isep.gorgeoussandwich.model;


import javax.persistence.*;

@Entity
@Table(name="review")
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name="grade") float
    @Embedded
    private Grade grade;

    @Column(name = "sandwichId")
    private long sandwichId;

    @Column(name="userId")
    private long userId;

    public Review(){}

    public Review(Grade grade, long sandwichId, long userId){
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
