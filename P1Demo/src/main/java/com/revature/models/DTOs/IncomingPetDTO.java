package com.revature.models.DTOs;

import java.util.UUID;

//Remember what a DTO is? Data Transfer Object
//This Class will be used to model incoming Pet JSON data
    //We get to skip the petId, and we can just use an int for User instead of a whole User object
public class IncomingPetDTO {

    private String species;
    private String name;
    private UUID userId;

    //boilerplate code--------------------------

    public IncomingPetDTO() {
    }

    public IncomingPetDTO(String species, String name, UUID userId) {
        this.species = species;
        this.name = name;
        this.userId = userId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
