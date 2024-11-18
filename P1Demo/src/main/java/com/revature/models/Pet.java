package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.UUID;

@Entity //This Class will be a DB table thanks to Spring Data JPA
@Table(name = "pets") //This lets us change the name of our DB table
@Component //1 of 4 stereotype annotations. Registers this class as a Spring Bean
public class Pet {

    @Id //This is the primary key field
    @GeneratedValue(strategy = GenerationType.UUID) //Makes a serial incrementing PK
    private UUID petId;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String name;


    /*Primary Key / Foreign Key relationship!! (Many to One)

     fetch - defines whether the Dependency (User) is eagerly or lazily loaded
        -eager = loads dependency as soon as the app starts
        -lazy = loads dependency only when it's called

     @JoinColumn - defines the column that will be used to link these tables (PK of User)
        -We have to supply the name of the PK field that this FK is referring to */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId") //this links our FK to the PK in User (name names the column!)
    private User user;

    //boilerplate code-----------------------

    public Pet() {
    }

    public Pet(UUID petId, String species, String name, User user) {
        this.petId = petId;
        this.species = species;
        this.name = name;
        this.user = user;
    }

    public UUID getPetId() {
        return petId;
    }

    public void setPetId(UUID petId) {
        this.petId = petId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }

}
