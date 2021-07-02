package com.isep.gorgeoussandwich.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "name")
    @Embedded
    private Name name;

    //@Column(name = "description")
    @Embedded
    private Description description;

    //Boolean para quando for um user normal é verdadeiro um voluntário é falso??
    @Column(name = "isUser")
    private boolean isUser;

    public User(){
    }

    public User(Name name, Description description, boolean isUser){
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

