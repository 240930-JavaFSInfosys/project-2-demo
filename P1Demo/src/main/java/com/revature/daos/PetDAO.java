package com.revature.daos;

import com.revature.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//Check UserDAO for general notes about how Spring Data DAOs work

@Repository //make this class a Bean (1 of the 4 steretype annotations)
public interface PetDAO extends JpaRepository<Pet, UUID> {

    //Find all Pets by UserId
    //This custom method will need to look at the User object's userId in Pet
    public List<Pet> findByUserUserId(UUID userId);

    //"UserUserId"??
    //This property expression tells Spring to dig into the User object to find the UserId

}
