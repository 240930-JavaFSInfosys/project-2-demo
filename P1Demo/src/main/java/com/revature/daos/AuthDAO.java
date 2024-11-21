package com.revature.daos;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthDAO extends JpaRepository<User, UUID> {


    //to verify a user's login credentials are correct, we just find a user by username/password
    //if the user is not found, that means the username/password aren't valid
    User findByUsernameAndPassword(String username, String password);

}
