package com.isep.gorgeoussandwich.dto;

import com.isep.gorgeoussandwich.model.Description;
import com.isep.gorgeoussandwich.model.Designation;
import com.isep.gorgeoussandwich.model.Type;

public class SandwichDTO {


    private long sandwichId;

    private Designation designation;

    private Description description;

    private Type type;

    public SandwichDTO(Designation designation, Description description, Type type) {

        this.designation = designation;
        this.description = description;
        this.type = type;
    }

    public SandwichDTO(long sandwichId, Designation designation, Description description, Type type) {
        this.sandwichId = sandwichId;
        this.designation = designation;
        this.description = description;
        this.type = type;
    }

    public SandwichDTO() {
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type){ this.type=type; }

    public long getSandwichId(){return sandwichId;}

    public void setSandwichId(long sandwichId) {
        this.sandwichId = sandwichId;
    }
}
