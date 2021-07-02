package com.isep.gorgeoussandwich.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    //Boolean para quando for um user normal é verdadeiro um voluntário é falso??
    @Column(name = "isUser")
    private boolean isUser;

    public User(){
    }

    public User(String name, String description, boolean isUser){
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

