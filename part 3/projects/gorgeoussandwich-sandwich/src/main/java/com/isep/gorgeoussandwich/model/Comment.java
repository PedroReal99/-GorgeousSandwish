package com.isep.gorgeoussandwich.model;


import javax.persistence.*;


@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name="description")
    @Embedded
    private Description description;

    @Column(name = "sandwichId")
    private long sandwichId;

    @Column(name="userId")
    private long userId;

    public Comment(Description description, long sandwichId, long userId){
        this.description=description;
        this.sandwichId=sandwichId;
        this.userId=userId;
    }

    public Comment(){}

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