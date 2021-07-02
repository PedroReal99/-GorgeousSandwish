package com.isep.gorgeoussandwich.dto;

public class SandwichDTO {


    private long sandwichId;

    private String designation;

    private String description;

    private String type;

    public SandwichDTO(String designation, String description, String type) {

        this.designation = designation;
        this.description = description;
        this.type = type;
    }

    public SandwichDTO(long sandwichId, String designation, String description, String type) {
        this.sandwichId = sandwichId;
        this.designation = designation;
        this.description = description;
        this.type = type;
    }

    public SandwichDTO() {
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){ this.type=type; }

    public long getSandwichId(){return sandwichId;}

    public void setSandwichId(long sandwichId) {
        this.sandwichId = sandwichId;
    }
}
